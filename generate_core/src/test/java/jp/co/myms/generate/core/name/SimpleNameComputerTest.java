package jp.co.myms.generate.core.name;

import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.resource.ResourceWrapper;
import org.apache.commons.io.FilenameUtils;
import jp.co.myms.generate.core.name.SimpleNameComputer.*;
import mockit.Mocked;
import mockit.Expectations;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.co.myms.generate.core.param.StringGeneratorParameter;
import jp.co.myms.generate.core.resource.ResourcesUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleNameComputerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComputeOutputFileNames() {
		SimpleNameComputer<String> target = new SimpleNameComputer<>();
		String actual = target.computeOutputFileNames(ResourcesUtils.createFactory().createResource("output.vm"), new StringGeneratorParameter());
		assertThat(actual, is("output.txt"));

	}

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(SimpleNameComputer.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		SimpleNameComputer target = new SimpleNameComputer();
		assertThat(target, notNullValue());
	}

	@Mocked 
	ResourceWrapper computeOutputFileNames_Arg_ResourceWrapper_GeneratorParameter_templateFile;

	@Test
	public void computeOutputFileNames_Arg_ResourceWrapper_GeneratorParameter() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		SimpleNameComputer target = new SimpleNameComputer();
		ResourceWrapper templateFile = this.computeOutputFileNames_Arg_ResourceWrapper_GeneratorParameter_templateFile;
		GeneratorParameter<Object> parameter = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		String actual = target.computeOutputFileNames(templateFile, parameter);
		// Assert
		String expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
