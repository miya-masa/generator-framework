package jp.co.myms.generate.core.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

@SuppressWarnings("unchecked")
public class ResourcesUtils {

	private static Class<? extends ResourceFactory> resourceFactoryClass;

	static {
		try {
			resourceFactoryClass = (Class<? extends ResourceFactory>) Class.forName("jp.co.myms.generate.core.resource.filesystem.SystemResourceFactory");
		} catch (ClassNotFoundException e) {
			throw new AssertionError();
		}
	}

	public static ResourceFactory getFactory() {
		try {
			return (ResourceFactory) resourceFactoryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new AssertionError();
		}
	}

	public static Collection<ResourceWrapper> listFiles(ResourceWrapper templateDir, String[] strings, boolean b) {
		List<ResourceWrapper> resourceWrappers = new ArrayList<>();
		if (templateDir instanceof DirectoryWrapper) {
			FileWrapper[] fileWrappers = ((DirectoryWrapper) templateDir).listFiles(b);
			for (FileWrapper fileWrapper : fileWrappers) {
				if (FilenameUtils.isExtension(fileWrapper.getName(), strings)) {
					resourceWrappers.add(fileWrapper);
				}
			}
		}
		return resourceWrappers;
	}

	public static void setResourceFactoryClass(Class<? extends ResourceFactory> resourceFactoryClass) {
		ResourcesUtils.resourceFactoryClass = resourceFactoryClass;
	}

}
