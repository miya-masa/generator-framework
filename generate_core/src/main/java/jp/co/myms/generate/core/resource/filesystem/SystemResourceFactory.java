package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

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

			if (uri.getScheme().equals("jar")) {
				Path tempDir = Files.createTempDirectory("tmp");
				Path tempFile = null;

				String[] segments = uri.getPath().split("\\!");
				String jarFilePath = segments[0];
				String classFilePath = segments[1];

				JarFile file = new JarFile(new File(jarFilePath));
				JarEntry entry = file.getJarEntry(path);
				List<InputStream> inputStreams = new ArrayList<>();
				if (entry.isDirectory()) {
					Enumeration<JarEntry> enumeration = file.entries();

					for (Enumeration<JarEntry> e = file.entries(); e.hasMoreElements();) {
					}

				} else {
					inputStreams.add(file.getInputStream(entry));
				}
				try {
					tempFile = Files.createFile(Paths.get(tempDir.toString(), path));
				} catch (NoSuchFileException e) {
					tempFile = Files.createDirectories(Paths.get(tempDir.toString(), path));
				}
				return null;
				//			Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
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
