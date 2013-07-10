package jp.co.myms.generate.core.template;

import java.util.Map;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * ファイル生成情報を作成するI/F.
 * 
 * @param <T> テンプレート生成情報の型
 * @author myms
 */
public interface TemplateInfoCreater<T> {

	/**
	 * ファイル生成情報を作成する.
	 * 
	 * @param parameter パラメータ
	 * @return ファイル生成情報
	 */
	Map<String, Object> create(GeneratorParameter<T> parameter);

}
