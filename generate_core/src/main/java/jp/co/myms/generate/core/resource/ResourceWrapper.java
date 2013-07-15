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

	boolean exists();

	String getPath();

	String getName();

	Writer getWriter(Charset encoding);

	boolean isFile();

	File getFile();

}
