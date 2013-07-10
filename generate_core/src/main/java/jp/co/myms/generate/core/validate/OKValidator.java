package jp.co.myms.generate.core.validate;

import java.util.List;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * 実装なしバリデータ.常にtrueを返す.
 * 
 * @param <T> テンプレート生成情報の型
 * @author myms
 */
public class OKValidator<T> implements GeneratorParameterValidator<T> {

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.validate.GeneratorParameterValidator#validate(jp.co.myms.generate.core.param.GeneratorParameter, java.util.List)
	 */
	@Override
	public boolean validate(GeneratorParameter<T> parameter, List<String> errorMessageList) {
		return true;
	}

}
