package jp.co.myms.generate.core.resource.filesystem;

import jp.co.myms.generate.core.resource.filesystem.SystemDirectoryWrapper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.myms.generate.core.resource.DirectoryWrapper;
import jp.co.myms.generate.core.resource.FileWrapper;
import jp.co.myms.generate.core.resource.ResourceWrapper;
public class SystemDirectoryWrapperTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(SystemDirectoryWrapper.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		File file = null;
		SystemDirectoryWrapper target = new SystemDirectoryWrapper(file);
		assertThat(target, notNullValue());
	}

	@Test
	public void isFile_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		File file = null;
		SystemDirectoryWrapper target = new SystemDirectoryWrapper(file);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.isFile();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void listFiles_Arg_boolean() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		File file = null;
		SystemDirectoryWrapper target = new SystemDirectoryWrapper(file);
		boolean recursive = false;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		FileWrapper[] actual = target.listFiles(recursive);
		// Assert
		FileWrapper[] expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

}
