package jp.co.myms.generate.core.exception;

/**
 * ジェネレータ生成例外.
 * 
 * @author myms
 */
public class GeneratorException extends RuntimeException {

	/**
	 * コンストラクタ.
	 */
	public GeneratorException() {
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message エラーメッセージ.
	 * @param cause 原因例外
	 */
	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message エラーメッセージ.
	 */
	public GeneratorException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param cause 原因例外.
	 */
	public GeneratorException(Throwable cause) {
		super(cause);
	}

}
