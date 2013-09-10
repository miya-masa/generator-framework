package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.GeneratorModule;
import jp.co.myms.generate.core.module.GeneratorModuleBuilder;
import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.param.StringGeneratorParameter;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneratorImplTest {

	private static File outputDir = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		outputDir = new File("output");
		outputDir.mkdir();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		FileUtils.deleteQuietly(outputDir);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("template");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		generator.generate(parameter);
		File actual = new File("output/template_utf_8.txt");
		assertThat(actual.exists(), is(true));
		List<String> lines = FileUtils.readLines(actual, Charset.forName("UTF-8"));
		assertThat(lines.size(), is(3));
		for (String string : lines) {
			assertThat(string, is("テストテストテストテストテスト"));
		}
	}

	@Test
	public void testTemplateDirIsFileSystem() throws IOException {

		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("src/test/resources/template");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		generator.generate(parameter);
		File actual = new File("output/template_utf_8.txt");
		assertThat(actual.exists(), is(true));
		List<String> lines = FileUtils.readLines(actual, Charset.forName("UTF-8"));
		assertThat(lines.size(), is(3));
		for (String string : lines) {
			assertThat(string, is("テストテストテストテストテスト"));
		}
	}

	@Test
	public void testNoOutputDir() throws IOException {

		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setTemplateDirectory("template");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testNoTemplateDir() throws IOException {

		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testNoTExistOutputDir() throws IOException {
		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("notexist");
		parameter.setTemplateDirectory("template");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testNoTExistTemplateDir() throws IOException {
		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("notexist");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testGeneratorException(final @Mocked GeneratorTaskMonitor generatorTaskMonitor) throws IOException {
		GeneratorModule<String> module = new GeneratorModuleBuilder<>(new MockTemplateInfoCreater()).setGeneratorTaskMonitor(generatorTaskMonitor).build();
		Generator<String> generator = GeneratorFactory.createGenerator(module);

		new NonStrictExpectations() {

			{
				generatorTaskMonitor.startTask(anyString, anyInt);
				result = new GeneratorException("例外発生");
			}
		};

		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("notexist");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isError(), is(true));
		assertThat(status.getErrorMessages().length > 0, is(true));
		assertThat(status.getErrorMessages()[0], is("例外発生"));
	}

	@Test
	public void type() throws Exception {
		// TODO auto-generated by JUnit Helper.
		assertThat(GeneratorImpl.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO auto-generated by JUnit Helper.
		GeneratorModule<Object> module = null;
		GeneratorImpl target = new GeneratorImpl(module);
		assertThat(target, notNullValue());
	}

	@Test
	public void generate_A$GeneratorParameter() throws Exception {
		// TODO auto-generated by JUnit Helper.
		GeneratorModule<Object> module = null;
		GeneratorImpl target = new GeneratorImpl(module);
		GeneratorParameter<Object> parameter = null;
		GeneratorStatus actual = target.generate(parameter);
		GeneratorStatus expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void generate_A_GeneratorParameter() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		GeneratorModule<Object> module = null;
		GeneratorImpl target = new GeneratorImpl(module);
		GeneratorParameter<Object> parameter = null;
		new Expectations() {
			{
				// 例 : mocked.get(anyString); returns(200);
			}
		};
		// Act
		GeneratorStatus actual = target.generate(parameter);
		// Assert
		GeneratorStatus expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void generate_Arg_GeneratorParameter() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		GeneratorModule<Object> module = null;
		GeneratorImpl target = new GeneratorImpl(module);
		GeneratorParameter<Object> parameter = null;
		new Expectations() {
			{
				// 例 : mocked.get(anyString); returns(200);
			}
		};
		// Act
		GeneratorStatus actual = target.generate(parameter);
		// Assert
		GeneratorStatus expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
