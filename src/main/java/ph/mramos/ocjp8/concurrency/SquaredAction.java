package ph.mramos.ocjp8.concurrency;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class SquaredAction extends RecursiveAction {

	private static final long serialVersionUID = 8260754428426619126L;

	private List<Integer> nums;
	private int start;
	private int end;
	
	public SquaredAction(List<Integer> nums, int start, int end) {
		this.nums = nums;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		if (end - start == 1) {
			nums.set(start, nums.get(start) * nums.get(start));
		} else {
			int middle = start + ((end - start) / 2);
			SquaredAction task1 = new SquaredAction(nums, start, middle);
			SquaredAction task2 = new SquaredAction(nums, middle, end);
			ForkJoinTask.invokeAll(task1, task2);
		}
	}

}
