package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourceWrapper;

public class SystemResourceFactory implements ResourceFactory {

	@Override
	public ResourceWrapper createResource(String path) {
		Objects.requireNonNull(path, "パスはNullにできません。");
		return internalCreateResource(new File(path));

	}

	private ResourceWrapper internalCreateResource(File file) {
		Objects.requireNonNull(file, "パスはNullにできません。");
		if (file.isFile()) {
			return new SystemFileWrapper(file);
		}
		return new SystemDirectoryWrapper(file);
	}

	@Override
	public ResourceWrapper createResourceFromClasspath(String path) {
		try {
			return internalCreateResource(new File(this.getClass().getClassLoader().getResource(path).toURI()));
		} catch (URISyntaxException e) {
			throw new GeneratorException(e);
		}
	}

	@Override
	public ResourceWrapper createResource(String outputDir, String fileNames) {
		return new SystemFileWrapper(new File(outputDir, fileNames));
	}

}
