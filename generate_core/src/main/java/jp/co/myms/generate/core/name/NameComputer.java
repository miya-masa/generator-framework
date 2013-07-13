package jp.co.myms.generate.core.name;

import java.io.File;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * 出力ファイル名の計算I/F.
 * 
 * @param <T> テンプレート変数生成パラメータの型
 * @author myms
 */
public interface NameComputer<T> {

	/**
	 * テンプレートファイルと紐づく出力ファイル名を計算する.
	 * 
	 * @param <T>
	 * @param templateFile テンプレートファイル
	 * @param parameter ジェネレータパラメータ
	 * @return テンプレートファイルに紐づく出力ファイル名
	 */
	String computeOutputFileNames(File templateFile, GeneratorParameter<T> parameter);
}
