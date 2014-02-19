package jp.co.myms.generate.core.resource.filesystem;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;

public class TmpFileManeger {

	private static ThreadLocal<List<Path>> tmpFiles = new ThreadLocal<List<Path>>() {
		@Override
		protected List<Path> initialValue() {
			return new ArrayList<>();
		}
	};

	public static void cleanTmpDirectoryRecursive() {
		List<Path> paths = tmpFiles.get();
		for (Path path : paths) {
			try {
				Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						if (!Files.isDirectory(file)) {
							Files.delete(file);
						}
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Path createTmpDirectory(Path dir, String prefix) {
		Path path = null;
		try {
			path = Files.createTempDirectory(dir, prefix);
			tmpFiles.get().add(path);
			return path;
		} catch (IOException e) {
			throw new GeneratorException(e);
		}

	}
}
