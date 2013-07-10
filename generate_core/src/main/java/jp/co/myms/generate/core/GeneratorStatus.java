package jp.co.myms.generate.core;

import java.util.ArrayList;
import java.util.List;

import jp.co.myms.generate.core.exception.GeneratorException;

public class GeneratorStatus {

	/** 情報メッセージ. */
	private List<String> infoMessages = new ArrayList<>();
	/** エラーメッセージ. */
	private List<String> errorMessages = new ArrayList<>();
	/** ジェネレート実行時の例外.*/
	private GeneratorException exception = null;
	/** 入力チェックメッセージ. */
	private List<String> validationErrorMessages = new ArrayList<>();

	public boolean isError() {
		return errorMessages.size() > 0;
	}

	public boolean isValidationError() {
		return validationErrorMessages.size() > 0;
	}

	public boolean isSuccess() {
		return !isError() && !isValidationError();
	}

	/**
	 * 情報メッセージを取得する.
	 * @return 情報メッセージ
	 */
	public List<String> getInfoMessages() {
		return infoMessages;
	}

	/**
	 * エラーメッセージを取得する.
	 * @return エラーメッセージ
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * ジェネレート実行時の例外を取得する.
	 * @return ジェネレート実行時の例外
	 */
	public GeneratorException getException() {
		return exception;
	}

	/**
	 * ジェネレート実行時の例外を設定する.
	 * @param exception ジェネレート実行時の例外
	 */
	public void setException(GeneratorException exception) {
		this.exception = exception;
	}

	/**
	 * 入力チェックメッセージを取得する.
	 * @return 入力チェックメッセージ
	 */
	public List<String> getValidationErrorMessages() {
		return validationErrorMessages;
	}

}
