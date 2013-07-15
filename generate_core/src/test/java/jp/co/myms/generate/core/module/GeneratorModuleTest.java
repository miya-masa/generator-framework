package jp.co.myms.generate.core.module;

import jp.co.myms.generate.core.module.GeneratorModule.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;
public class GeneratorModuleTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(GeneratorModule.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		assertThat(target, notNullValue());
	}

	@Test
	public void getNameComputer_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		NameComputer<Object> actual = target.getNameComputer();
		// Assert
		NameComputer<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setNameComputer_Arg_NameComputer() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		NameComputer<Object> nameComputer = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.setNameComputer(nameComputer);
		// Assert
	}

	@Test
	public void getTemplateInfoCreater_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		TemplateInfoCreater<Object> actual = target.getTemplateInfoCreater();
		// Assert
		TemplateInfoCreater<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void getGeneratorParameterValidator_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		GeneratorParameterValidator<Object> actual = target.getGeneratorParameterValidator();
		// Assert
		GeneratorParameterValidator<Object> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setGeneratorParameterValidator_Arg_GeneratorParameterValidator() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		TemplateInfoCreater<Object> templateInfoCreater = null;
		GeneratorModule target = new GeneratorModule(templateInfoCreater);
		GeneratorParameterValidator<Object> generatorParameterValidator = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.setGeneratorParameterValidator(generatorParameterValidator);
		// Assert
	}

}
