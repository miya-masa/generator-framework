package jp.co.myms.generate.core.task;

import jp.co.myms.generate.core.task.LogTaskMonitor.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogTaskMonitorTest {

	@Test
	public void type() throws Exception {
		// TODO JUnit Helper による自動生成
		assertThat(LogTaskMonitor.class, notNullValue());
	}

	@Test
	public void instantiation() throws Exception {
		// TODO JUnit Helper による自動生成
		LogTaskMonitor target = new LogTaskMonitor();
		assertThat(target, notNullValue());
	}

	@Test
	public void startTask_Arg_String_int() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		LogTaskMonitor target = new LogTaskMonitor();
		String taskName = null;
		int totalTask = 0;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.startTask(taskName, totalTask);
		// Assert
	}

	@Test
	public void subTask_Arg_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		LogTaskMonitor target = new LogTaskMonitor();
		String subTaskName = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.subTask(subTaskName);
		// Assert
	}


	@Test
	public void end_Arg_String() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		LogTaskMonitor target = new LogTaskMonitor();
		String message = null;
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		target.end(message);
		// Assert
	}

	@Test
	public void isRunning_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		LogTaskMonitor target = new LogTaskMonitor();
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.isRunning();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void checkCancel_Arg_() throws Exception {
		// TODO JUnit Helper による自動生成
		// Arrange
		LogTaskMonitor target = new LogTaskMonitor();
		new Expectations(){{
			// 例 : mocked.get(anyString); returns(200);
		}};
		// Act
		boolean actual = target.checkCancel();
		// Assert
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

}
