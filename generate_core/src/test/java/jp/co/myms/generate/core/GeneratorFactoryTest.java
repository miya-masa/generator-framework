package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.GeneratorModule;
import jp.co.myms.generate.core.module.GeneratorModuleBuilder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeneratorFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void type() throws Exception {
		assertThat(GeneratorFactory.class, notNullValue());
	}

	@Test
	public void createGenerator_Arg_GeneratorModule() throws Exception {
		// Arrange
		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		// Act
		Generator<String> actual = GeneratorFactory.createGenerator(module);
		// Assert
		assertThat(actual, instanceOf(GeneratorImpl.class));
	}

	@Test
	public void createGenerator_Arg_GeneratorModule_nullArg() throws Exception {
		// Arrange
		GeneratorModule<Object> module = null;
		// Act
		GeneratorFactory.createGenerator(module);
		// Assert
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("ジェネレータモジュールはnullを引数にできません。");
	}

}
