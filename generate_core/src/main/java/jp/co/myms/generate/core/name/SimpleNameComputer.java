package jp.co.myms.generate.core.name;

import java.io.File;

import jp.co.myms.generate.core.param.GeneratorParameter;

import org.apache.commons.io.FilenameUtils;

/**
 * シンプルな名前計算クラス.
 * 
 * @param <T> テンプレート変数生成パラメータ型
 * @author myms
 * 
 */
public class SimpleNameComputer<T> implements NameComputer<T> {

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.name.NameComputer#computeOutputFileNames(java.io.File[], jp.co.myms.generate.core.param.GeneratorParameter)
	 */
	@Override
	public String computeOutputFileNames(File templateFile, GeneratorParameter<T> parameter) {
		return FilenameUtils.getBaseName(templateFile.getPath()) + ".txt";
	}

}
