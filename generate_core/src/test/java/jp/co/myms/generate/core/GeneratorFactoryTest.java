package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.BaseGeneratorModule;

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
		BaseGeneratorModule<String> module = new BaseGeneratorModule(new MockTemplateInfoCreater());
		// Act
		StringGenerator actual = GeneratorFactory.createGenerator(StringGenerator.class, module);
		// Assert
		assertThat(actual, instanceOf(StringGenerator.class));
	}

	@Test
	public void createGenerator_Arg_GeneratorModule_nullArg() throws Exception {
		// Arrange
		BaseGeneratorModule<Object> module = null;
		// Act
		GeneratorFactory.createGenerator(StringGenerator.class, module);
		// Assert
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("ジェネレータモジュールはnullを引数にできません.");
	}

}
