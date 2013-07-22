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

/**
 * システムリソース用の抽象クラス.
 * 
 * @author myms
 * 
 */
public abstract class AbstractSystemResourceWrapper implements ResourceWrapper {

	/** ファイル実体. */
	private final File rawFile;

	/**
	 * コンストラクタ.
	 * 
	 * @param file 実体ファイル
	 */
	public AbstractSystemResourceWrapper(File file) {
		Objects.requireNonNull(file);
		this.rawFile = file;
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#exists()
	 */
	@Override
	public boolean exists() {
		return rawFile.exists();
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#getPath()
	 */
	@Override
	public String getPath() {
		return rawFile.getPath();
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#getName()
	 */
	@Override
	public String getName() {
		return rawFile.getName();
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#getWriter(java.nio.charset.Charset)
	 */
	@Override
	public Writer getWriter(Charset encoding) {

		try {
			return new OutputStreamWriter(new FileOutputStream(rawFile), encoding);
		} catch (FileNotFoundException e) {
			throw new GeneratorException(e);
		}
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#getFile()
	 */
	@Override
	public File getFile() {
		return rawFile;
	}

}
