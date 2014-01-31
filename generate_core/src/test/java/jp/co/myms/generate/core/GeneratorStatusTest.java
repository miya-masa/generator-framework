package jp.co.myms.generate.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;
import org.slf4j.Logger;

public class GeneratorStatusTest {

	@Test
	public void type() throws Exception {
		assertThat(GeneratorStatus.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		GeneratorStatus target = new GeneratorStatus();
		assertThat(target, notNullValue());
	}

	@Test
	public void isError_Arg_() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		// Act
		boolean actual = target.isError();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isError_Arg_True(final @Mocked Logger mockLogger) throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addErrorMessages(mockLogger, "error");
		// Act
		boolean actual = target.isError();
		// Assert
		boolean expected = true;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isValidationError_Arg_() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		// Act
		boolean actual = target.isValidationError();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isValidationError_Arg_True() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addValidationErrorMessage(null, "message");
		// Act
		boolean actual = target.isValidationError();
		// Assert
		boolean expected = true;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isSuccess_Arg_() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		// Act
		boolean actual = target.isSuccess();
		// Assert
		boolean expected = true;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isSuccess_Arg_Validation() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addValidationErrorMessage(null, "str");
		// Act
		boolean actual = target.isSuccess();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void isSuccess_Arg_Error() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addErrorMessages(null, "error");
		// Act
		boolean actual = target.isSuccess();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void getInfoMessages_Arg_() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		// Act
		String[] actual = target.getInfoMessages();
		// Assert
		assertThat(actual.length, is(equalTo(0)));
	}

	@Test
	public void getInfoMessages_Arg_Message() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addInfoMessage(null, "message");
		// Act
		String[] actual = target.getInfoMessages();
		// Assert
		assertThat(actual.length, is(equalTo(1)));
		assertThat(actual[0], is(equalTo("message")));
	}

	@Mocked
	Logger addInfoMessage_Arg_Logger_StringArray_logger;

	@Test
	public void addInfoMessage_Arg_Logger_StringArray() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		final Logger logger = this.addInfoMessage_Arg_Logger_StringArray_logger;
		new Expectations() {
			{
				logger.info(withEqual("message"));
			}
		};
		// Act
		target.addInfoMessage(logger, "message");
		// Assert
	}

	@Test
	public void addInfoMessage_Arg_Logger_StringArray_MultiMessage() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		final Logger logger = this.addInfoMessage_Arg_Logger_StringArray_logger;
		new Expectations() {
			{
				logger.info(withEqual("message,message2"));
			}
		};
		// Act
		target.addInfoMessage(logger, "message", "message2");
		// Assert
	}

	@Mocked
	Logger addErrorMessages_Arg_Logger_StringArray_logger;

	@Test
	public void addErrorMessages_Arg_Logger_StringArray() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		final Logger logger = this.addErrorMessages_Arg_Logger_StringArray_logger;
		new Expectations() {
			{
				logger.error(withEqual("error"));
			}
		};
		// Act
		target.addErrorMessages(logger, "error");
		// Assert
	}

	@Test
	public void addErrorMessages_Arg_Logger_StringArray_Multi() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		final Logger logger = this.addErrorMessages_Arg_Logger_StringArray_logger;
		new Expectations() {
			{
				logger.error(withEqual("error,error2"));
			}
		};
		// Act
		target.addErrorMessages(logger, "error", "error2");
		// Assert
	}

	@Test
	public void getValidationErrorMessages_Arg_() throws Exception {
		GeneratorStatus target = new GeneratorStatus();
		// Act
		String[] actual = target.getValidationErrorMessages();
		// Assert
		assertThat(actual.length, is(equalTo(0)));
	}

	@Test
	public void getValidationErrorMessages_Arg_OneMessage() throws Exception {
		GeneratorStatus target = new GeneratorStatus();
		target.addValidationErrorMessage(null, "message");
		// Act
		String[] actual = target.getValidationErrorMessages();
		// Assert
		assertThat(actual.length, is(equalTo(1)));
		assertThat(actual[0], is(equalTo("message")));
	}

	@Mocked
	Logger addValidationErrorMessage_Arg_Logger_StringArray_logger;

	@Test
	public void addValidationErrorMessage_Arg_Logger_StringArray() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		final Logger logger = this.addValidationErrorMessage_Arg_Logger_StringArray_logger;
		new Expectations() {
			{
				logger.info(withEqual("message"));
			}
		};
		// Act
		target.addValidationErrorMessage(logger, "message");
		// Assert
	}

	@Test
	public void getErrorMessages_Arg_() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		// Act
		String[] actual = target.getErrorMessages();
		// Assert
		assertThat(actual.length, is(equalTo(0)));
	}

	@Test
	public void getErrorMessages_Arg_OneMessage() throws Exception {
		// Arrange
		GeneratorStatus target = new GeneratorStatus();
		target.addErrorMessages(null, "message");
		// Act
		String[] actual = target.getErrorMessages();
		// Assert
		assertThat(actual.length, is(equalTo(1)));
		assertThat(actual[0], is(equalTo("message")));
	}

}
