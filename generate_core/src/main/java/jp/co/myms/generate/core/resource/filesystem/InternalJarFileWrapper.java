package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.resource.FileWrapper;

public class InternalJarFileWrapper implements FileWrapper {

	private File dummyFile;

	public InternalJarFileWrapper(JarFile jarFile, JarEntry jarEntry) throws IOException {
		Path tmpDir = TmpFileManeger.createTmpDirectory(Paths.get("."), "tmp");
		init(jarFile, jarEntry, tmpDir);

	}

	public InternalJarFileWrapper(JarFile jarFile, JarEntry jarEntry, Path tmpDir) throws IOException {

		init(jarFile, jarEntry, tmpDir);
	}

	private void init(JarFile jarFile, JarEntry jarEntry, Path tmpDir) throws IOException {
		Path tmpPath = Files.createFile(Paths.get(tmpDir.toAbsolutePath().toString(), jarEntry.getName()));
		Files.copy(jarFile.getInputStream(jarEntry), tmpPath, StandardCopyOption.REPLACE_EXISTING);
		this.dummyFile = tmpPath.toFile();
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public String getPath() {
		return dummyFile.getPath();
	}

	@Override
	public String getName() {
		return dummyFile.getName();
	}

	@Override
	public Writer getWriter(Charset encoding) {
		try {
			return new OutputStreamWriter(new FileOutputStream(dummyFile), encoding);
		} catch (FileNotFoundException e) {
			throw new GeneratorException(e);
		}
	}

	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public File getFile() {
		return dummyFile;
	}

}
