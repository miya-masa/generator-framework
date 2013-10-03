package jp.co.myms.generate.core.task;

public class SubTaskMonitor implements GeneratorTaskMonitor {

	private GeneratorTaskMonitor parent;
	private int totalChildTaskForParent;
	private int workedParentTask;
	private int totalSubTask;
	private int workedSubTask;

	public SubTaskMonitor(GeneratorTaskMonitor parent, int totalChildTaskForParent) {
		this.parent = parent;
		this.totalChildTaskForParent = totalChildTaskForParent;
	}

	@Override
	public void work(int work) {
		workedSubTask += work;
		int workedParentTask = totalChildTaskForParent * workedSubTask / totalSubTask;
		parent.work(Math.abs(this.workedParentTask - workedParentTask));
		this.workedParentTask = workedParentTask;
	}

	@Override
	public boolean isRunning() {
		return parent.isRunning();
	}

	@Override
	public void startTask(String taskName, int totalTask) {
		this.totalSubTask = totalTask;
		parent.subTask(taskName);
	}

	@Override
	public void subTask(String subTaskName) {
		parent.subTask(subTaskName);
	}

	@Override
	public void end(String message) {
		work(totalSubTask - workedSubTask);
	}

	@Override
	public boolean checkCancel() {
		return parent.checkCancel();
	}

}
