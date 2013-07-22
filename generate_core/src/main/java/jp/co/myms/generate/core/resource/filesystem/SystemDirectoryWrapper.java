package jp.co.myms.generate.core.resource.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.co.myms.generate.core.resource.DirectoryWrapper;
import jp.co.myms.generate.core.resource.FileWrapper;
import jp.co.myms.generate.core.resource.ResourceWrapper;

/**
 * ファイルシステム用ディレクトリラッパークラス.
 * 
 * @author myms
 * 
 */
public class SystemDirectoryWrapper extends AbstractSystemResourceWrapper implements DirectoryWrapper {

	/**
	 * コンストラクタ.
	 * 
	 * @param file 実体ファイル
	 */
	public SystemDirectoryWrapper(File file) {
		super(file);
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.ResourceWrapper#isFile()
	 */
	@Override
	public boolean isFile() {
		return false;
	}

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.resource.DirectoryWrapper#listFiles(boolean)
	 */
	@Override
	public FileWrapper[] listFiles(boolean recursive) {

		List<FileWrapper> fileWrappers = new ArrayList<>();
		File directory = getFile();

		File[] files = directory.listFiles();
		for (File file : files) {
			ResourceWrapper resourceWrapper = new SystemResourceFactory().createResource(file.getPath());
			if (resourceWrapper.isFile()) {
				fileWrappers.add((FileWrapper) resourceWrapper);
			}
		}

		return (FileWrapper[]) fileWrappers.toArray(new FileWrapper[fileWrappers.size()]);
	}
}
