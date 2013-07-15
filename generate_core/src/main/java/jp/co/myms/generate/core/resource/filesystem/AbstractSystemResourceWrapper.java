package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Objects;

import jp.co.myms.generate.core.exception.GeneratorException;
import jp.co.myms.generate.core.resource.ResourceWrapper;

public abstract class AbstractSystemResourceWrapper implements ResourceWrapper {

	private final File rawFile;

	public AbstractSystemResourceWrapper(File file) {
		Objects.requireNonNull(file);
		this.rawFile = file;
	}

	@Override
	public boolean exists() {
		return rawFile.exists();
	}

	@Override
	public String getPath() {
		return rawFile.getPath();
	}

	@Override
	public String getName() {
		return rawFile.getName();
	}

	@Override
	public Writer getWriter(Charset encoding) {

		try {
			return new OutputStreamWriter(new FileOutputStream(rawFile), encoding);
		} catch (FileNotFoundException e) {
			throw new GeneratorException(e);
		}
	}


	@Override
	public File getFile() {
		return rawFile;
	}

}
