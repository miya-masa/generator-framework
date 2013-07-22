package jp.co.myms.generate.core.resource;

/**
 * リソースを生成するためのファクトリクラス.
 * 
 * @author myms
 * 
 */
public interface ResourceFactory {

	/**
	 * パスからリソースを生成する.
	 * 
	 * @param path パス
	 * @return リソース
	 */
	ResourceWrapper createResource(String path);

	/**
	 * クラスパスからリソースを生成する.
	 * 
	 * @param path クラスパス
	 * @return リソース
	 */
	ResourceWrapper createResourceFromClasspath(String path);

	/**
	 * ディレクトリ内に存在するリソースを取得する.
	 * 
	 * @param dir 親ディレクトリ
	 * @param resourceName 親ディレクトリ内に存在するリソース名
	 * @return リソース
	 */
	ResourceWrapper createResource(String dir, String resourceName);

}
