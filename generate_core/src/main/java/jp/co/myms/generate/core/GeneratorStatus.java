package jp.co.myms.generate.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import jp.co.myms.generate.core.exception.GeneratorException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

/**
 * ジェネレータ実行後のステータス.
 * 
 * @author myms
 */
public class GeneratorStatus {

	/** 情報メッセージ. */
	private List<String> infoMessages = new ArrayList<>();
	/** エラーメッセージ. */
	private List<String> errorMessages = new ArrayList<>();
	/** ジェネレート実行時の例外. */
	private GeneratorException exception = null;
	/** 入力チェックメッセージ. */
	private List<String> validationErrorMessages = new ArrayList<>();

	/**
	 * エラー終了かどうかを判定する.
	 * 
	 * @return エラー終了かどうか
	 */
	public boolean isError() {
		return errorMessages.size() > 0;
	}

	/**
	 * 入力パラメータエラーかどうかを判定する.
	 * 
	 * @return 入力パラメータエラーかどうか
	 */
	public boolean isValidationError() {
		return validationErrorMessages.size() > 0;
	}

	/**
	 * 成功したかどうかを判定する.
	 * 
	 * @return 成功したかどうか
	 */
	public boolean isSuccess() {
		return !isError() && !isValidationError();
	}

	/**
	 * 情報メッセージを取得する.
	 * 
	 * @return 情報メッセージ
	 */
	public String[] getInfoMessages() {
		return (String[]) infoMessages.toArray(new String[infoMessages.size()]);
	}

	/**
	 * 情報メッセージを追加する.メッセージはINFOでログ出力される.
	 * 
	 * @param logger ロガー
	 * @param infoMessage 情報メッセージ(非null)
	 */
	public void addInfoMessage(Logger logger, String... infoMessage) {
		Objects.requireNonNull(infoMessage);
		logger.info(StringUtils.join(infoMessage));
		Collections.addAll(infoMessages, infoMessage);
	}

	/**
	 * エラーメッセージを取得する.
	 * 
	 * @return エラーメッセージ
	 */
	public String[] getErrorMessages() {
		return (String[]) errorMessages.toArray(new String[errorMessages.size()]);
	}

	/**
	 * エラーメッセージを追加する.メッセージはERRORでログ出力される.
	 * 
	 * @param logger ロガー
	 * @param errorMessage エラーメッセージ(非null)
	 */
	public void addErrorMessages(Logger logger, String... errorMessage) {
		Objects.requireNonNull(errorMessage);
		logger.error(StringUtils.join(errorMessage));
		Collections.addAll(errorMessages, errorMessage);
	}

	/**
	 * ジェネレート実行時の例外を取得する.
	 * 
	 * @return ジェネレート実行時の例外
	 */
	public GeneratorException getException() {
		return exception;
	}

	/**
	 * ジェネレート実行時の例外を設定する.
	 * 
	 * @param exception ジェネレート実行時の例外
	 */
	public void setException(GeneratorException exception) {
		this.exception = exception;
	}

	/**
	 * 入力チェックメッセージを取得する.
	 * 
	 * @return 入力チェックメッセージ
	 */
	public String[] getValidationErrorMessages() {
		return (String[]) validationErrorMessages.toArray(new String[validationErrorMessages.size()]);
	}

	/**
	 * 入力チェックエラーメッセージを追加する.メッセージはInfoでログ出力される.
	 * 
	 * @param logger ロガー
	 * @param validationErrorMessage 入力チェックエラーメッセージ(非null)
	 */
	public void addValidationErrorMessage(Logger logger, String... validationErrorMessage) {
		Objects.requireNonNull(validationErrorMessage);
		logger.info(StringUtils.join(validationErrorMessage));
		Collections.addAll(validationErrorMessages, validationErrorMessage);
	}

}
