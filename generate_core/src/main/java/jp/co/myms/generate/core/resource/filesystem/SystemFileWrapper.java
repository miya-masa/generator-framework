package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;

import jp.co.myms.generate.core.resource.FileWrapper;

public class SystemFileWrapper extends AbstractSystemResourceWrapper implements FileWrapper {

	public SystemFileWrapper(File file) {
		super(file);
	}

	@Override
	public boolean isFile() {
		return true;
	}
}
