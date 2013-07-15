package jp.co.myms.generate.core.template;

import jp.co.myms.generate.core.template.VariableMap.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class VariableMapTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(VariableMap.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		VariableMap target = new VariableMap();
		assertThat(target, notNullValue());
	}

	@Test
	public void put_Arg_String_Object() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		VariableMap target = new VariableMap();
		String key = null;
		Object value = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.put(key, value);
		// Assert
	}

	@Test
	public void entrySet_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		VariableMap target = new VariableMap();
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		Set actual = target.entrySet();
		// Assert
		Set expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
