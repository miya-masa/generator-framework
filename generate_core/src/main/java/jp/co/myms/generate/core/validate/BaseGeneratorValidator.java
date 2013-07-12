package jp.co.myms.generate.core.validate;

import java.io.File;
import java.util.List;

import jp.co.myms.generate.core.param.GeneratorParameter;

import org.apache.commons.lang.StringUtils;

/**
 * パラメータの入力チェックの抽象クラス.
 * 
 * @param <T> テンプレート生成情報の型
 * @author myms
 */
public class BaseGeneratorValidator<T> implements GeneratorParameterValidator<T> {

	/* (非 Javadoc)
	 * @see jp.co.myms.generate.core.validate.GeneratorParameterValidator#validate(jp.co.myms.generate.core.param.GeneratorParameter, java.util.List)
	 */
	@Override
	public boolean validate(GeneratorParameter<T> parameter, List<String> errorMessageList) {
		int size = errorMessageList.size();
		if (checkRequired(parameter.getOutputDirectory(), errorMessageList, "出力先ディレクトリが指定されていません。")) {
			checkExistFile(parameter.getOutputDirectory(), errorMessageList, "出力先ディレクトリが存在しません", false);
		}
		if (checkRequired(parameter.getTemplateDirectory(), errorMessageList, "テンプレートディレクトリが指定されていません")) {
			checkExistFile(parameter.getTemplateDirectory(), errorMessageList, "テンプレートディレクトリが存在しません", true);
		}
		doTemplateParamValidate(parameter.getTemplateParameter(), errorMessageList);
		return errorMessageList.size() == size;
	}

	/**
	 * 必須チェックを行う.
	 * 
	 * @param target チェック対象
	 * @param errorMessageList エラーメッセージリスト
	 * @param errorMessage エラーメッセージ
	 * @return 正常だった場合はtrue、そうでない場合はfalse
	 */
	protected boolean checkRequired(String target, List<String> errorMessageList, String errorMessage) {
		if (!checkNull(target, errorMessageList, errorMessage)) {
			return false;
		}
		if (StringUtils.isEmpty(target)) {
			errorMessageList.add(errorMessage);
			return false;
		}
		return true;
	}

	/**
	 * Nullチェックを行う.
	 * 
	 * @param target チェック対象
	 * @param errorMessageList エラーメッセージリスト
	 * @param errorMessage エラーが存在した場合のエラーメッセージ
	 * @return 正常だった場合はtrue、そうでない場合はfalse
	 */
	protected boolean checkNull(Object target, List<String> errorMessageList, String errorMessage) {
		if (target == null) {
			errorMessageList.add(errorMessage);
			return false;
		}
		return true;
	}

	/**
	 * テンプレート生成情報の入力チェックをする.エラーがある場合はerrorMessageListにメッセージを追加する.
	 * 
	 * @param templateParameter テンプレートパラメータ
	 * @param errorMessageList エラーメッセージリスト
	 */
	protected void doTemplateParamValidate(T templateParameter, List<String> errorMessageList) {

	};

	/**
	 * ファイルの存在チェックを行う.
	 * 
	 * @param filePath チェックするファイルパス
	 * @param errorMessageList エラーメッセージ
	 * @param errorMessage エラーが存在した場合に追加するメッセージ
	 * @param checkClassPath クラスパス内もチェックするかどうか
	 * @return 正常だった場合はtrue、そうでない場合はfalse
	 */
	protected boolean checkExistFile(String filePath, List<String> errorMessageList, String errorMessage, boolean checkClassPath) {
		boolean existsFilePath = new File(filePath).exists();
		if (existsFilePath) {
			return true;
		}

		if (checkClassPath) {
			boolean existsClassPath = this.getClass().getClassLoader().getResource(filePath) != null;
			if (existsClassPath) {
				return true;
			}
		}
		errorMessageList.add(errorMessage);
		return false;
	}
}
