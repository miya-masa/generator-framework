package jp.co.myms.generate.core.param;

import jp.co.myms.generate.core.param.StringGeneratorParameter.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

public class StringGeneratorParameterTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(StringGeneratorParameter.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		StringGeneratorParameter target = new StringGeneratorParameter();
		assertThat(target, notNullValue());
	}

}
