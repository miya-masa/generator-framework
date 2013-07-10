package jp.co.myms.generate.core.validate;

import java.util.List;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * パラメータの入力チェックの抽象クラス.
 * 
 * @param <T> テンプレート生成情報の型
 * @author myms
 */
public abstract class AbstractGeneratorValidator<T> implements GeneratorParameterValidator<T> {
	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.validate.GeneratorParameterValidator#validate(jp.co.myms.generate.core.param.GeneratorParameter, java.util.List)
	 */
	@Override
	public boolean validate(GeneratorParameter<T> parameter, List<String> errorMessageList) {
		doTemplateParamValidate(parameter.getTemplateParameter(), errorMessageList);
		return errorMessageList.size() == 0;
	}

	/**
	 * テンプレート生成情報の入力チェックをする.エラーがある場合はerrorMessageListにメッセージを追加する.
	 * 
	 * @param templateParameter テンプレートパラメータ
	 * @param errorMessageList エラーメッセージリスト
	 */
	protected abstract void doTemplateParamValidate(T templateParameter, List<String> errorMessageList);
}
