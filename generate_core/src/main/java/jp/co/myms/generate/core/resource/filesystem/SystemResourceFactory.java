package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourceWrapper;

/**
 * ファイルシステム用リソースファクトリクラス.
 * 
 * @author myms
 * 
 */
public class SystemResourceFactory implements ResourceFactory {

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceFactory#createResource(java.lang.String)
	 */
	@Override
	public ResourceWrapper createResource(String path) {
		Objects.requireNonNull(path, "パスはNullにできません。");
		return internalCreateResource(new File(path));

	}

	/**
	 * リソースを生成する.
	 * 
	 * @param file ファイル実体
	 * @return リソース
	 */
	private ResourceWrapper internalCreateResource(File file) {
		Objects.requireNonNull(file, "パスはNullにできません。");
		if (file.isFile()) {
			return new SystemFileWrapper(file);
		}
		return new SystemDirectoryWrapper(file);
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceFactory#createResourceFromClasspath(java.lang.String)
	 */
	@Override
	public ResourceWrapper createResourceFromClasspath(String path) {
		try {
			return internalCreateResource(new File(this.getClass().getClassLoader().getResource(path).toURI()));
		} catch (URISyntaxException e) {
			throw new GeneratorException(e);
		}
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceFactory#createResource(java.lang.String, java.lang.String)
	 */
	@Override
	public ResourceWrapper createResource(String outputDir, String fileNames) {
		return new SystemFileWrapper(new File(outputDir, fileNames));
	}

}
