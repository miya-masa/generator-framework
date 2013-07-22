package jp.co.myms.generate.core.resource;

import java.io.File;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * ジェネレータでファイルを扱うためのラッパーI/F.
 * 
 * @author myms
 * 
 */
public interface ResourceWrapper {

	/**
	 * ファイルが存在するかどうか.
	 * 
	 * @return ファイルが存在するかどうか.
	 */
	boolean exists();

	/**
	 * パスを取得する.
	 * 
	 * @return パス
	 */
	String getPath();

	/**
	 * 名前を取得する.
	 * 
	 * @return 名前
	 */
	String getName();

	/**
	 * 書き込み用Writerを取得する.
	 * 
	 * @param encoding エンコーディング
	 * @return 書き込み用Writer
	 */
	Writer getWriter(Charset encoding);

	/**
	 * ファイルかどうかを判定する.
	 * 
	 * @return ファイルかどうか
	 */
	boolean isFile();

	/**
	 * java.io.Fileとしてリソースを取得する.
	 * 
	 * @return ファイル
	 */
	File getFile();

}
