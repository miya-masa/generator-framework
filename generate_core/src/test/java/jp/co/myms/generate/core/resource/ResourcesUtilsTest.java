package jp.co.myms.generate.core.resource;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collection;

import mockit.Expectations;

import org.junit.Test;

public class ResourcesUtilsTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(ResourcesUtils.class, notNullValue());
	}

	@Test
	public void getFactory_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		new Expectations() {
			{
				// 例 : mocked.get(anyString); returns(200);
			}
		};
		// Act
		ResourceFactory actual = ResourcesUtils.createFactory();
		// Assert
		ResourceFactory expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void listFiles_Arg_ResourceWrapper_StringArray_boolean() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		ResourceWrapper templateDir = null;
		String[] strings = new String[] {};
		boolean b = false;
		new Expectations() {
			{
				// 例 : mocked.get(anyString); returns(200);
			}
		};
		// Act
		Collection<ResourceWrapper> actual = ResourcesUtils.listFiles(templateDir, strings, b);
		// Assert
		Collection<ResourceWrapper> expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setResourceFactoryClass_Arg_Class() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		Class resourceFactoryClass = null;
		new Expectations() {
			{
				// 例 : mocked.get(anyString); returns(200);
			}
		};
		// Act
		ResourcesUtils.setResourceFactoryClass(resourceFactoryClass);
		// Assert
	}

}
