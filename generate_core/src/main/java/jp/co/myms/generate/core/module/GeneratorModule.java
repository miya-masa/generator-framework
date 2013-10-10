package jp.co.myms.generate.core.module;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

public interface GeneratorModule<T> {

	GeneratorTaskMonitor getGeneratorTaskMonitor();

	GeneratorParameterValidator<T> getGeneratorParameterValidator();

	TemplateInfoCreater<T> getTemplateInfoCreater();

	NameComputer<T> getNameComputer();

}
