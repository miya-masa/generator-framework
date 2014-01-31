package jp.co.myms.generate.core.validate;

import java.util.ArrayList;
import jp.co.myms.generate.core.validate.OKValidator.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.util.List;
import jp.co.myms.generate.core.param.GeneratorParameter;
public class OKValidatorTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(OKValidator.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		OKValidator target = new OKValidator();
		assertThat(target, notNullValue());
	}

	@Test
	public void validate_Arg_GeneratorParameter_List() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		OKValidator target = new OKValidator();
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

}
