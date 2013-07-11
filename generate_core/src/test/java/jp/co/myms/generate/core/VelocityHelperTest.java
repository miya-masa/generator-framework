/**
 * 
 */
package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.co.myms.generate.core.helper.VelocityHelper;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author myms
 * 
 */
public class VelocityHelperTest {

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
		target.merge("template/template.vm", "output/output.txt");
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

}
