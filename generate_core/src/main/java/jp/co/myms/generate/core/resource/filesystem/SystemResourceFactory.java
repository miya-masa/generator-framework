package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
		Objects.requireNonNull(path, "パスはNullにできません.");
		return internalCreateResource(new File(path));

	}

	/**
	 * リソースを生成する.
	 * 
	 * @param file ファイル実体
	 * @return リソース
	 */
	private ResourceWrapper internalCreateResource(File file) {
		Objects.requireNonNull(file, "パスはNullにできません.");
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
			URI uri = this.getClass().getClassLoader().getResource(path).toURI();
			System.out.println(URLDecoder.decode(uri.toASCIIString(), "UTF-8"));
			if (uri.getScheme().equals("jar")) {
				String[] segments = URLDecoder.decode(uri.toASCIIString(), "UTF-8").split("\\!");
				String jarFilePath = segments[0];

				jarFilePath = jarFilePath.replace("jar:file:", "");
				JarFile file = new JarFile(new File(jarFilePath));
				JarEntry entry = file.getJarEntry(path);
				if (entry.isDirectory()) {
					return new InternalJarDirectoryWrapper(file, entry);
				} else {
					return new InternalJarFileWrapper(file, entry);
				}
			} else {
				return internalCreateResource(new File(uri));
			}

		} catch (IOException e) {
			throw new GeneratorException(e);
		} catch (URISyntaxException e1) {
			throw new GeneratorException(e1);
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
