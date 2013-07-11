package jp.co.myms.generate.core.task;

/**
 * 
 * ジェネレータ実行のタスクモニター.
 * 
 * @author myms
 * 
 */
public interface GeneratorTaskMonitor {

	/**
	 * タスクを開始する.
	 * 
	 * @param taskName タスク名
	 * @param totalTask 全タスク量
	 */
	void startTask(String taskName, int totalTask);

	/**
	 * サブタスクを開始する.
	 * 
	 * @param subTaskName サブタスク名
	 */
	void subTask(String subTaskName);

	/**
	 * タスクを進める.
	 * 
	 * @param work 進めるタスク量
	 */
	void work(int work);

	/**
	 * タスクを終了する.
	 * 
	 * @param message メッセージ
	 */
	void end(String message);

	/**
	 * ジェネレートが実行中かどうか判定する.
	 * 
	 * @return ジェネレートが実行中かどうか.
	 */
	boolean isRunning();

	/**
	 * 実行をキャンセルされたかどうかを判定する.
	 * 
	 * @return 実行がキャンセルされたかどうか.
	 */
	boolean checkCancel();
}
