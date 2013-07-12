package jp.co.myms.generate.core.template;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * ファイル生成情報を作成するI/F.
 * 
 * @param <T> テンプレート生成情報の型
 * @author myms
 */
public interface TemplateInfoCreater<T> {

	/**
	 * テンプレート変数情報をセットする.
	 * 
	 * @param map 変数Map
	 * @param parameter パラメータ
	 */
	void setUpVariableMap(VariableMap map, GeneratorParameter<T> parameter);

}
