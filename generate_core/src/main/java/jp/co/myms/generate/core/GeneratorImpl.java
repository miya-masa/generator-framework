package jp.co.myms.generate.core;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.helper.VelocityHelper;
import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.NameMappings;
import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ジェネレータのデフォルト実装.
 * 
 * @author myms
 * @param <T>
 * @param <T>
 *
 */
public class GeneratorImpl<T> implements Generator<T> {

	/** ロガー. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorImpl.class);

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
	public GeneratorImpl(AbstractGeneratorModule<T> module) {
		this.nameComputer = module.getNameComputer();
		this.templateInfoCreater = module.getTemplateInfoCreater();
		this.generatorParameterValidator = module.getGeneratorParameterValidator();
		this.generatorTaskMonitor = module.getGeneratorTaskMonitor();
	}

	@Override
	public GeneratorStatus generate(GeneratorParameter<T> parameter) {
		GeneratorStatus status = new GeneratorStatus();
		try {

			List<String> errorMessageList = new ArrayList<>();
			if (!generatorParameterValidator.validate(parameter, errorMessageList)) {
				status.getValidationErrorMessages().addAll(errorMessageList);
				return status;
			}

			VelocityHelper helper = new VelocityHelper();
			String templateDirPath = parameter.getTemplateDirectory();
			String outputDir = parameter.getOutputDirectory();
			File templateDir = new File(templateDirPath);
			if (!templateDir.exists()) {
				templateDir = new File(this.getClass().getClassLoader().getResource(templateDirPath).toURI());
			}

			Collection<File> templateFiles = FileUtils.listFiles(templateDir, new String[] { GeneratorConstant.EXTENSION_TEMPLATE }, false);
			NameMappings nameMappings = nameComputer.computeOutputFileNames((File[]) templateFiles.toArray(new File[templateFiles.size()]), parameter);
			helper.putAll(templateInfoCreater.create(parameter));
			for (File file : templateFiles) {
				helper.merge(templateDirPath + "/" + file.getName(), new File(outputDir, nameMappings.getFileName(file, "none.txt")));
			}

		} catch (GeneratorException e) {
			status.getErrorMessages().add(e.getMessage());
			status.setException(e);
		} catch (URISyntaxException e) {
			status.getErrorMessages().add(e.getMessage());
		}

		return status;

	}
}
