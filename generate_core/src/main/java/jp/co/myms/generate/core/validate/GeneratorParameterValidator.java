package jp.co.myms.generate.core.validate;

import java.util.List;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * ジェネレータパラメータのバリデータI/F.
 * @param <T> テンプレート生成情報型
 * @author myms
 */
public interface GeneratorParameterValidator<T> {

	/**
	 * 入力チェックを行う.
	 * 
	 * @param parameter パラメータ
	 * @param errorMessageList エラーメッセージリスト
	 * @return エラーが存在しない場合はtrue、そうでない場合はfalse
	 */
	boolean validate(GeneratorParameter<T> parameter, List<String> errorMessageList);
}
