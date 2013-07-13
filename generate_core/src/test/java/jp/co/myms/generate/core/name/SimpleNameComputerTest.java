package jp.co.myms.generate.core.name;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.File;

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
		String actual = target.computeOutputFileNames(new File("output.vm"), new StringGeneratorParameter());
		assertThat(actual, is("output.txt"));

	}
}
