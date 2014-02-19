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



}
