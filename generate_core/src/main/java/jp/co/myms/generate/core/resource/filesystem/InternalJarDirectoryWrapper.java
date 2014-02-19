package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import jp.co.myms.generate.core.resource.DirectoryWrapper;
import jp.co.myms.generate.core.resource.FileWrapper;

public class InternalJarDirectoryWrapper implements DirectoryWrapper {

	private List<FileWrapper> dirFiles = new ArrayList<>();
	private DirectoryWrapper root;
	private String rootDirName;

	public InternalJarDirectoryWrapper(JarFile jarFile, JarEntry jarEntry) throws IOException {
		Path tmpDir = TmpFileManeger.createTmpDirectory(Paths.get("."), "tmp");
		this.root = new SystemDirectoryWrapper(
				Files.createDirectories(Paths.get(tmpDir.toString(), jarEntry.getName())).toFile());
		this.rootDirName = jarEntry.getName();
		setDirFiles(jarFile, jarEntry, tmpDir);
	}

	protected void setDirFiles(JarFile jarFile, JarEntry jarEntry, Path tmpDir) throws IOException {
		for (Enumeration<JarEntry> e = jarFile.entries(); e.hasMoreElements();) {
			JarEntry dirFile = e.nextElement();
			if (dirFile.isDirectory()) {
				Files.createDirectories(Paths.get(tmpDir.toString(), dirFile.getName()));
			} else if (dirFile.getName().startsWith(rootDirName)) {
				this.dirFiles.add(new InternalJarFileWrapper(jarFile, dirFile, tmpDir));
			}
		}
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public String getPath() {
		return root.getPath();
	}

	@Override
	public String getName() {
		return root.getName();
	}

	@Override
	public Writer getWriter(Charset encoding) {
		return null;
	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public File getFile() {
		return root.getFile();
	}

	@Override
	public FileWrapper[] listFiles(boolean recursive) {
		return (FileWrapper[]) dirFiles.toArray(new FileWrapper[dirFiles.size()]);
	}

}
