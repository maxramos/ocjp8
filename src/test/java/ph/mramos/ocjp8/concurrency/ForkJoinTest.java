package ph.mramos.ocjp8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class ForkJoinTest {

	@Test
	public void testRecursiveAction() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		RecursiveAction task = new SquaredAction(nums, 0, nums.size());
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		for (int num : nums) {
			System.out.println(num);
		}
	}

	@Test
	public void testRecursiveTask() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 55
		RecursiveTask<Integer> task = new SumTask(nums, 0, nums.size());
		ForkJoinPool pool = new ForkJoinPool();
		Integer result= pool.invoke(task);
		
		System.out.println(result);
	}
	
}
