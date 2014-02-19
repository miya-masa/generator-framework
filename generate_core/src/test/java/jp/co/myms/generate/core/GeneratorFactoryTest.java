package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.BaseGeneratorModule;
import jp.co.myms.generate.core.module.StringGeneratorModule;

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
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		// Act
		StringGenerator actual = GeneratorFactory.createGenerator(StringGenerator.class, module);
		// Assert
		assertThat(actual, instanceOf(StringGenerator.class));
	}

	@Test(expected = NullPointerException.class)
	public void createGenerator_Arg_GeneratorModule_nullArg() throws Exception {
		// Arrange
		StringGeneratorModule module = null;
		// Act
		GeneratorFactory.createGenerator(StringGenerator.class, module);
	}

}
