package jp.co.myms.generate.core.exception;

public class GeneratorException extends RuntimeException {

	public GeneratorException() {
	}

	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneratorException(String message) {
		super(message);
	}

	public GeneratorException(Throwable cause) {
		super(cause);
	}

}
