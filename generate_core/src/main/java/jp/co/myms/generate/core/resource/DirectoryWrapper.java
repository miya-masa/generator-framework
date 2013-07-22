package jp.co.myms.generate.core.resource;

/**
 * ディレクトリのラッパーI/F.
 * 
 * @author myms
 */
public interface DirectoryWrapper extends ResourceWrapper {

	/**
	 * ディレクトリ内に存在するファイルを取得する.
	 * 
	 * @param recursive 再帰的に検索するかどうか
	 * @return ディレクトリ内のファイル
	 */
	FileWrapper[] listFiles(boolean recursive);

}
