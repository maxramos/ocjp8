package ph.mramos.ocjp8.concurrency;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 6729892452980533456L;

	private List<Integer> nums;
	private int start;
	private int end;
	
	public SumTask(List<Integer> nums, int start, int end) {
		this.nums = nums;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		if (end - start == 1) {
			return nums.get(start);
		} else {
			int middle = start + ((end - start) / 2);
			SumTask task1 = new SumTask(nums, start, middle);
			SumTask task2 = new SumTask(nums, middle, end);
			task1.fork(); // 1st
			Integer task2Result = task2.compute(); // 2nd
			Integer task1Result = task1.join(); // 3rd
			return task1Result + task2Result;
		}
	}

}
