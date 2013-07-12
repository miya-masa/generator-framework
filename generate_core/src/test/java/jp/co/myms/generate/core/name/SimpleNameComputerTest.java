package jp.co.myms.generate.core.name;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.co.myms.generate.core.param.StringGeneratorParameter;

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
		List<File> templateFiles = new ArrayList<>();
		templateFiles.add(new File("output.vm"));
		templateFiles.add(new File("output2.vm"));
		NameMappings actual = target.computeOutputFileNames((File[]) templateFiles.toArray(new File[templateFiles.size()]), new StringGeneratorParameter());
		assertThat(actual.getFileName(templateFiles.get(0)), is("output.txt"));
		assertThat(actual.getFileName(templateFiles.get(1)), is("output2.txt"));

	}
}
