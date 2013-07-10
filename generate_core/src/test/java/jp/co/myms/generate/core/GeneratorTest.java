package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.param.StringGeneratorParameter;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneratorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new File("output").mkdir();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		new File("output").deleteOnExit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		Generator<String> generator = GeneratorFactory.createGenerator(new AbstractGeneratorModule<String>() {
			@Override
			protected void configure() {
				setTemplateInfoCreater(new MockTemplateInfoCreater());
			}
		});
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("template");
		parameter.setTemplateParameter("templateParam");
		generator.generate(parameter);
		File actual = new File("output/template.txt");
		assertThat(actual.exists(), is(true));
		List<String> lines = FileUtils.readLines(actual);
		assertThat(lines.size(), is(3));
		for (String string : lines) {
			assertThat(string, is("templateParam"));
		}
	}
}
