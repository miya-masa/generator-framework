package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;

import jp.co.myms.generate.core.resource.FileWrapper;

/**
 * ファイルシステム用ラッパークラス.
 * 
 * @author myms
 * 
 */
public class SystemFileWrapper extends AbstractSystemResourceWrapper implements FileWrapper {

	/**
	 * コンストラクタ.
	 * 
	 * @param file 実体ファイル
	 */
	public SystemFileWrapper(File file) {
		super(file);
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#isFile()
	 */
	@Override
	public boolean isFile() {
		return true;
	}
}
