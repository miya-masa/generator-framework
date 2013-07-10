package jp.co.myms.generate.core.exception;

import java.util.List;

public class ValidateException extends GeneratorException {

	private List<String> errorMessages;

	public ValidateException(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

}
