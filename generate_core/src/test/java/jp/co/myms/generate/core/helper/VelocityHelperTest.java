package jp.co.myms.generate.core.helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.co.myms.generate.core.exception.VelocityRuntimeException;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourceWrapper;
import jp.co.myms.generate.core.resource.ResourcesUtils;
import mockit.Mocked;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VelocityHelperTest {

	private static File outputDir = null;
	private static ResourceFactory factory = ResourcesUtils.createFactory();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVelocitySupport() throws IOException {
		VelocityHelper target = new VelocityHelper();
		target.put("key0", "value0");
		target.put("key1", "value1");
		target.put("key2", "value2");
		target.merge("template/template_utf_8.vm", "output/output.txt");
		File actual = new File("output/output.txt");
		assertThat(actual.exists(), is(true));
		List<String> lines = FileUtils.readLines(actual);
		assertThat(lines.size(), is(3));
		int i = 0;
		for (String string : lines) {
			assertThat(string, is("value" + i));
			i++;
		}
	}

	@Test
	public void type() throws Exception {
		assertThat(VelocityHelper.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		VelocityHelper target = new VelocityHelper();
		assertThat(target, notNullValue());
	}

	@Mocked
	ResourceWrapper merge_Arg_String_ResourceWrapper_outputFile;

	@Test
	public void merge_Arg_String_ResourceWrapper() throws Exception {
		// Arrange
		VelocityHelper target = new VelocityHelper();
		String templatePath = null;
		ResourceWrapper outputFile = this.merge_Arg_String_ResourceWrapper_outputFile;
		thrown.expect(VelocityRuntimeException.class);
		thrown.expectCause(isA(ResourceNotFoundException.class));
		// Act
		target.merge(templatePath, outputFile);
		// Assert
	}

	@Test
	public void merge_Arg_String_ResourceWrapper_success() throws Exception {
		// Arrange
		VelocityHelper target = new VelocityHelper();
		target.put("key0", "value0");
		target.put("key1", "value1");
		target.put("key2", "value2");
		File file = new File("output/output.txt");
		// Act
		target.merge("template/template_utf_8.vm", factory.createResource("output/output.txt"));
		// Assert
		assertThat(file.exists(), is(true));
		List<String> lines = FileUtils.readLines(file);
		assertThat(lines.size(), is(3));
		int i = 0;
		for (String string : lines) {
			assertThat(string, is("value" + i));
			i++;
		}
	}

	@Test
	public void merge_Arg_String_String() throws Exception {
		// Arrange
		VelocityHelper target = new VelocityHelper();
		String templatePath = null;
		String outputFile = null;
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("パスはNullにできません.");
		// Act
		target.merge(templatePath, outputFile);
		// Assert
	}
	//
	//	@Mocked
	//	Writer merge_Arg_String_Writer_writer;
	//
	//	@Test
	//	public void merge_Arg_String_Writer() throws Exception {
	//		// TODO JUnit Helper による自動生成
	//		// Arrange
	//		VelocityHelper target = new VelocityHelper();
	//		String templatePath = null;
	//		Writer writer = this.merge_Arg_String_Writer_writer;
	//		new Expectations() {
	//			{
	//				// 例 : mocked.get(anyString); returns(200);
	//			}
	//		};
	//		// Act
	//		target.merge(templatePath, writer);
	//		// Assert
	//	}

	//	@Mocked
	//	VariableMap putAll_Arg_VariableMap_variableMap;

	//	@Test
	//	public void putAll_Arg_VariableMap() throws Exception {
	//		// TODO JUnit Helper による自動生成
	//		// Arrange
	//		VelocityHelper target = new VelocityHelper();
	//		VariableMap variableMap = this.putAll_Arg_VariableMap_variableMap;
	//		//		new Expectations() {
	//		//			{
	//		//				// 例 : mocked.get(anyString); returns(200);
	//		//			}
	//		//		};
	//		// Act
	//		target.putAll(variableMap);
	//		// Assert
	//	}

}
