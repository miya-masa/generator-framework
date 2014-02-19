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



}
