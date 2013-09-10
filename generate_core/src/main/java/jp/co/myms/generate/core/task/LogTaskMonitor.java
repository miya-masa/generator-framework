package jp.co.myms.generate.core.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ログ出力タスクモニター.
 * 
 * @author myms
 */
public class LogTaskMonitor implements GeneratorTaskMonitor {

	/** ロガー. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogTaskMonitor.class);

	/** 総タスク量. */
	private Integer totalTask;
	/** 残タスク. */
	private Integer done;

	@Override
	public void startTask(String taskName, int totalTask) {
		this.totalTask = totalTask;
		this.done = 0;
		LOGGER.info("タスクを開始します.タスク名：{} 総タスク量：{}", taskName, totalTask);
	}

	@Override
	public void subTask(String subTaskName) {
		LOGGER.info("サブタスクを開始します.サブタスク名:{}", subTaskName);
	}

	@Override
	public void work(int work) {
		this.done += work;
		LOGGER.info("タスクを進めます.進捗:{}{}", this.done * 100 / this.totalTask, "%");
	}

	@Override
	public void end(String message) {
		this.totalTask = null;
		this.done = null;
		LOGGER.info("タスクを終了します.{}", message);
	}

	@Override
	public boolean isRunning() {
		return this.totalTask != null && this.done != null;
	}

	@Override
	public boolean checkCancel() {
		return false;
	}

}
