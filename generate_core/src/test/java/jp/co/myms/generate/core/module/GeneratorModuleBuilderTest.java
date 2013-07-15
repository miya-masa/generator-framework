package jp.co.myms.generate.core.module;

import jp.co.myms.generate.core.module.GeneratorModuleBuilder.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.SimpleNameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.task.LogTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.BaseGeneratorValidator;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;
public class GeneratorModuleBuilderTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(GeneratorModuleBuilder.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModuleBuilder target = new GeneratorModuleBuilder(templateInfoCreater);
		assertThat(target, notNullValue());
	}

	@Test
	public void setNameComputer_Arg_NameComputer() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModuleBuilder target = new GeneratorModuleBuilder(templateInfoCreater);
		NameComputer<Object> nameComputer = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		GeneratorModuleBuilder<Object> actual = target.setNameComputer(nameComputer);
		// Assert
		GeneratorModuleBuilder<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setGeneratorParameterValidator_Arg_GeneratorParameterValidator() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModuleBuilder target = new GeneratorModuleBuilder(templateInfoCreater);
		GeneratorParameterValidator<Object> generatorParameterValidator = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		GeneratorModuleBuilder<Object> actual = target.setGeneratorParameterValidator(generatorParameterValidator);
		// Assert
		GeneratorModuleBuilder<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void build_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModuleBuilder target = new GeneratorModuleBuilder(templateInfoCreater);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		GeneratorModule<Object> actual = target.build();
		// Assert
		GeneratorModule<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
