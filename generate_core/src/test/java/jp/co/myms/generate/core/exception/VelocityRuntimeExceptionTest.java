package jp.co.myms.generate.core.exception;

import jp.co.myms.generate.core.exception.VelocityRuntimeException.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

public class VelocityRuntimeExceptionTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(VelocityRuntimeException.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		String message = null;
		Throwable cause = null;
		VelocityRuntimeException target = new VelocityRuntimeException(message, cause);
		assertThat(target, notNullValue());
	}

}
