package jp.co.myms.generate.core;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.helper.VelocityHelper;
import jp.co.myms.generate.core.module.GeneratorModule;
import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.NameMappings;
import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.template.VariableMap;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ジェネレータのデフォルト実装.
 * 
 * @author myms
 * @param <T>
 */
public class GeneratorImpl<T> implements Generator<T> {

	/** ロガー. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorImpl.class);

	/** タスク量：入力チェック. */
	private static final int TASK_VALIDATION = 100;

	/** タスク量：パラメータ解析. */
	private static final int TASK_PARSE_PARAM = 50;

	/** タスク量：名前計算/. */
	private static final int TASK_NAME_COMPUTE = 100;

	/** タスク量：テンプレート変数の生成. */
	private static final int TASK_CREATE_TEMPLATE_INFO = 200;

	/** タスク量：ファイル生成. */
	private static final int TASK_GENERATE_FILE = 200;

	/** タスク量：総量. */
	private static final int TASK_TOTAL = TASK_VALIDATION + TASK_PARSE_PARAM + TASK_NAME_COMPUTE + TASK_CREATE_TEMPLATE_INFO + TASK_GENERATE_FILE;

	/** テンプレートファイルと出力ファイル名のマッピング計算クラス. */
	private NameComputer<T> nameComputer;

	/** テンプレートにバインドする情報生成クラス. */
	private TemplateInfoCreater<T> templateInfoCreater;

	/** バリデータ. */
	private GeneratorParameterValidator<T> generatorParameterValidator;

	/** タスクモニター. */
	private GeneratorTaskMonitor generatorTaskMonitor;

	/**
	 * @param module モジュール
	 */
	public GeneratorImpl(GeneratorModule<T> module) {
		this.nameComputer = module.getNameComputer();
		this.templateInfoCreater = module.getTemplateInfoCreater();
		this.generatorParameterValidator = module.getGeneratorParameterValidator();
		this.generatorTaskMonitor = module.getGeneratorTaskMonitor();
	}

	@Override
	public GeneratorStatus generate(GeneratorParameter<T> parameter) {

		GeneratorStatus status = new GeneratorStatus();
		try {
			generatorTaskMonitor.startTask("ジェネレートを開始します。", TASK_TOTAL);
			List<String> errorMessageList = new ArrayList<>();
			generatorTaskMonitor.subTask("入力チェックをします。");
			if (!generatorParameterValidator.validate(parameter, errorMessageList)) {
				status.addValidationErrorMessage(LOGGER, (String[]) errorMessageList.toArray(new String[errorMessageList.size()]));
				generatorTaskMonitor.end("入力チェックエラーが発生しました.");
				return status;
			}
			generatorTaskMonitor.work(TASK_VALIDATION);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("パラメータから値を取得します.");
			VelocityHelper helper = new VelocityHelper();
			String templateDirPath = parameter.getTemplateDirectory();
			status.addInfoMessage(LOGGER, "テンプレートディレクトリパス : " + templateDirPath);
			String outputDir = parameter.getOutputDirectory();
			status.addInfoMessage(LOGGER, "出力先 : " + outputDir);
			File templateDir = new File(templateDirPath);
			if (!templateDir.exists()) {
				templateDir = new File(this.getClass().getClassLoader().getResource(templateDirPath).toURI());
			}
			Collection<File> templateFiles = FileUtils.listFiles(templateDir, new String[] { GeneratorConstant.EXTENSION_TEMPLATE }, false);
			status.addInfoMessage(LOGGER, "テンプレートファイル名: " + StringUtils.join(templateFiles, ','));

			generatorTaskMonitor.work(TASK_PARSE_PARAM);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("テンプレートファイルと紐づく名前を取得します。");
			NameMappings nameMappings = new NameMappings();
			nameComputer.computeOutputFileNames(nameMappings, (File[]) templateFiles.toArray(new File[templateFiles.size()]), parameter);
			generatorTaskMonitor.work(TASK_NAME_COMPUTE);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("テンプレートに埋め込む変数情報を取得します。");
			VariableMap variableMap = new VariableMap();
			templateInfoCreater.setUpVariableMap(variableMap, parameter);
			helper.putAll(variableMap);
			generatorTaskMonitor.work(TASK_CREATE_TEMPLATE_INFO);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("ファイルを生成します。");
			int taskAtFile = TASK_GENERATE_FILE / templateFiles.size();
			for (File file : templateFiles) {
				File outputFile = new File(outputDir, nameMappings.getFileName(file, "none.txt"));
				status.addInfoMessage(LOGGER, "出力ファイル：" + outputFile.getPath());
				helper.merge(templateDirPath + "/" + file.getName(), outputFile);
				generatorTaskMonitor.work(taskAtFile);
			}

		} catch (GeneratorException e) {
			LOGGER.error("ジェネレータ実行中にエラーが発生しました。", e);
			status.addErrorMessages(LOGGER, e.getMessage());
			status.setException(e);
		} catch (URISyntaxException e) {
			LOGGER.error("ジェネレータ実行中にエラーが発生しました。", e);
			status.addErrorMessages(LOGGER, e.getMessage());
		}
		generatorTaskMonitor.end("ジェネレートを終了します.");
		return status;

	}
}
