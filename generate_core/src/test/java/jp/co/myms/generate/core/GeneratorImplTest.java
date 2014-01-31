package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.BaseGeneratorModule;
import jp.co.myms.generate.core.module.StringGeneratorModule;
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
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
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

		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
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

		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setTemplateDirectory("template");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testNoTemplateDir() throws IOException {

		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateParameter("テストテストテストテストテスト");
		GeneratorStatus status = generator.generate(parameter);
		assertThat(status.isValidationError(), is(true));
		assertThat(status.getValidationErrorMessages().length > 0, is(true));
	}

	@Test
	public void testNoTExistOutputDir() throws IOException {
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
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
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
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
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		module.setGeneratorTaskMonitor(generatorTaskMonitor);
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);

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

}
