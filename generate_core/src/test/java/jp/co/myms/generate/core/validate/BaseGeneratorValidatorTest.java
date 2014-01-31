package jp.co.myms.generate.core.validate;

import java.util.ArrayList;
import jp.co.myms.generate.core.validate.BaseGeneratorValidator.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.io.File;
import java.util.List;
import jp.co.myms.generate.core.param.GeneratorParameter;
import org.apache.commons.lang.StringUtils;
public class BaseGeneratorValidatorTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(BaseGeneratorValidator.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		assertThat(target, notNullValue());
	}

	@Test
	public void validate_Arg_GeneratorParameter_List() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		GeneratorParameter<Object> parameter = null;
		List<String> errorMessageList = new ArrayList<String>();
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.validate(parameter, errorMessageList);
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void checkRequired_Arg_String_List_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		String target_ = null;
		List<String> errorMessageList = new ArrayList<String>();
		String errorMessage = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.checkRequired(target_, errorMessageList, errorMessage);
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void checkNull_Arg_Object_List_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		Object target_ = null;
		List<String> errorMessageList = new ArrayList<String>();
		String errorMessage = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.checkNull(target_, errorMessageList, errorMessage);
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void doTemplateParamValidate_Arg_Object_List() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		Object templateParameter = null;
		List<String> errorMessageList = new ArrayList<String>();
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.doTemplateParamValidate(templateParameter, errorMessageList);
		// Assert
	}

	@Test
	public void checkExistFile_Arg_String_List_String_boolean() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		BaseGeneratorValidator target = new BaseGeneratorValidator();
		String filePath = null;
		List<String> errorMessageList = new ArrayList<String>();
		String errorMessage = null;
		boolean checkClassPath = false;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.checkExistFile(filePath, errorMessageList, errorMessage, checkClassPath);
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

}
