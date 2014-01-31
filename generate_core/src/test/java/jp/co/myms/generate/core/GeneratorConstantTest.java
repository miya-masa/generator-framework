package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GeneratorConstantTest {

	@Test
	public void type() throws Exception {
		assertThat(GeneratorConstant.class, notNullValue());
	}

}
