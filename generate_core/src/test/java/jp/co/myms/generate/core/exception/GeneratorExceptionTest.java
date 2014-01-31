package jp.co.myms.generate.core.exception;

import jp.co.myms.generate.core.exception.GeneratorException.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

public class GeneratorExceptionTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(GeneratorException.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		GeneratorException target = new GeneratorException();
		assertThat(target, notNullValue());
	}

}
