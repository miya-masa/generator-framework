package jp.co.myms.generate.core;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.helper.VelocityHelper;
import jp.co.myms.generate.core.module.GeneratorModule;
import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourceWrapper;
import jp.co.myms.generate.core.resource.ResourcesUtils;
import jp.co.myms.generate.core.resource.filesystem.TmpFileManeger;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.template.VariableMap;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ジェネレータのデフォルト実装.
 * 
 * @author myms
 * @param <I> テンプレート情報
 * @param <T> パラメータクラス
 */
public abstract class AbstractGenerator<T extends GeneratorParameter<I>, I> implements Generator<T, I> {

	/** ロガー. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGenerator.class);

	/** タスク量：入力チェック. */
	private static final int TASK_VALIDATION = 100;

	/** タスク量：パラメータ解析. */
	private static final int TASK_PARSE_PARAM = 50;

	/** タスク量：テンプレート変数の生成. */
	private static final int TASK_CREATE_TEMPLATE_INFO = 200;

	/** タスク量：ファイル生成. */
	private static final int TASK_GENERATE_FILE = 200;

	/** タスク量：総量. */
	private static final int TASK_TOTAL = TASK_VALIDATION + TASK_PARSE_PARAM + TASK_CREATE_TEMPLATE_INFO
			+ TASK_GENERATE_FILE;

	/** テンプレートファイルと出力ファイル名のマッピング計算クラス. */
	private NameComputer<I> nameComputer;

	/** テンプレートにバインドする情報生成クラス. */
	private TemplateInfoCreater<I> templateInfoCreater;

	/** バリデータ. */
	private GeneratorParameterValidator<I> generatorParameterValidator;

	/** タスクモニター. */
	private GeneratorTaskMonitor generatorTaskMonitor;

	/**
	 * @param module モジュール
	 */
	public AbstractGenerator(GeneratorModule<I> module) {
		Objects.requireNonNull(module, "ジェネレータモジュールはnullを引数にできません.");
		this.nameComputer = module.getNameComputer();
		this.templateInfoCreater = module.getTemplateInfoCreater();
		this.generatorParameterValidator = module.getGeneratorParameterValidator();
		this.generatorTaskMonitor = module.getGeneratorTaskMonitor();
	}

	@Override
	public GeneratorStatus generate(T parameter) {
		ResourceFactory factory = ResourcesUtils.createFactory();
		GeneratorStatus status = new GeneratorStatus();
		try {
			generatorTaskMonitor.startTask("ジェネレートを開始します.", TASK_TOTAL);
			List<String> errorMessageList = new ArrayList<>();
			generatorTaskMonitor.subTask("入力チェックをします.");
			if (!generatorParameterValidator.validate(parameter, errorMessageList)) {
				status.addValidationErrorMessage(LOGGER,
						(String[]) errorMessageList.toArray(new String[errorMessageList.size()]));
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
			ResourceWrapper templateDir = factory.createResource(templateDirPath);
			if (!templateDir.exists()) {
				templateDir = factory.createResourceFromClasspath(templateDirPath);
			}
			Collection<ResourceWrapper> templateFiles = ResourcesUtils.listFiles(templateDir,
					new String[] { GeneratorConstant.EXTENSION_TEMPLATE }, false);
			status.addInfoMessage(LOGGER, "テンプレートファイル名: " + StringUtils.join(templateFiles, ','));
			generatorTaskMonitor.work(TASK_PARSE_PARAM);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("テンプレートに埋め込む変数情報を取得します.");
			VariableMap variableMap = new VariableMap();
			templateInfoCreater.setUpVariableMap(variableMap, parameter);
			helper.putAll(variableMap);
			generatorTaskMonitor.work(TASK_CREATE_TEMPLATE_INFO);

			generatorTaskMonitor.checkCancel();
			generatorTaskMonitor.subTask("ファイルを生成します.");
			int taskAtFile = TASK_GENERATE_FILE / templateFiles.size();
			for (ResourceWrapper file : templateFiles) {
				ResourceWrapper outputFile = factory.createResource(outputDir,
						nameComputer.computeOutputFileNames(file, parameter));
				status.addInfoMessage(LOGGER, "出力ファイル" + outputFile.getPath());
				LOGGER.info("######################"
						+ Paths.get(".").toAbsolutePath().relativize(Paths.get(file.getPath()).toAbsolutePath())
								.toAbsolutePath()
								.toString());
				LOGGER.info("######################" + Paths.get(".").toAbsolutePath().toString());
				helper.merge(
						Paths.get("").toAbsolutePath().relativize(Paths.get(file.getPath()).toAbsolutePath())
								.toAbsolutePath()
								.toString()
								.replace(Paths.get("").toAbsolutePath().toString(), ""),
						outputFile);
				generatorTaskMonitor.work(taskAtFile);
			}
			TmpFileManeger.cleanTmpDirectoryRecursive();
		} catch (GeneratorException e) {
			LOGGER.error("ジェネレータ実行中にエラーが発生しました.", e);
			status.addErrorMessages(LOGGER, e.getMessage());
			status.setException(e);
		}
		generatorTaskMonitor.end("ジェネレートを終了します.");
		return status;

	}
}
