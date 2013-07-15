package jp.co.myms.generate.core.resource.filesystem;

import jp.co.myms.generate.core.resource.filesystem.SystemFileWrapper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import java.io.File;
import jp.co.myms.generate.core.resource.FileWrapper;
public class SystemFileWrapperTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(SystemFileWrapper.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		File file = null;
		SystemFileWrapper target = new SystemFileWrapper(file);
		assertThat(target, notNullValue());
	}

	@Test
	public void isFile_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		File file = null;
		SystemFileWrapper target = new SystemFileWrapper(file);
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.isFile();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

}
