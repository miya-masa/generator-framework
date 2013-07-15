package jp.co.myms.generate.core.resource.filesystem;

import jp.co.myms.generate.core.resource.filesystem.SystemResourceFactory.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.io.File;
import java.net.URISyntaxException;
import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourceWrapper;
public class SystemResourceFactoryTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(SystemResourceFactory.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		SystemResourceFactory target = new SystemResourceFactory();
		assertThat(target, notNullValue());
	}

	@Test
	public void createResource_Arg_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		SystemResourceFactory target = new SystemResourceFactory();
		String path = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		ResourceWrapper actual = target.createResource(path);
		// Assert
		ResourceWrapper expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void createResourceFromClasspath_Arg_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		SystemResourceFactory target = new SystemResourceFactory();
		String path = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		ResourceWrapper actual = target.createResourceFromClasspath(path);
		// Assert
		ResourceWrapper expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void createResource_Arg_String_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		SystemResourceFactory target = new SystemResourceFactory();
		String outputDir = null;
		String fileNames = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		ResourceWrapper actual = target.createResource(outputDir, fileNames);
		// Assert
		ResourceWrapper expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
