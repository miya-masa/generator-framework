package jp.co.myms.generate.core.exception;

/**
 * Velocity例外.
 * 
 * @author myms
 * 
 */
public class VelocityRuntimeException extends GeneratorException {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 * @param cause 原因例外
	 */
	public VelocityRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param message メッセージ
	 */
	public VelocityRuntimeException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param cause 原因例外
	 */
	public VelocityRuntimeException(Throwable cause) {
		super(cause);
	}

}
