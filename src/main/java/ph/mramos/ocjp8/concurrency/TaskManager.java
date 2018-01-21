package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskManager {

	public void performTask(CyclicBarrier cb1, CyclicBarrier cb2) {
		try {
			start();
//			System.out.println("C1 Parties: " + cb1.getParties() + ", Waiting: " + cb1.getNumberWaiting());
			cb1.await();
//			System.out.println("C1 Parties: " + cb1.getParties() + ", Waiting: " + cb1.getNumberWaiting());
			middle();
//			System.out.println("C2 Parties: " + cb2.getParties() + ", Waiting: " + cb2.getNumberWaiting());
			cb2.await();
//			System.out.println("C2 Parties: " + cb2.getParties() + ", Waiting: " + cb2.getNumberWaiting());
			end();
		} catch (InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void performTask() {
		start();
		middle();
		end();
	}
	
	private void start() {
		System.out.println("Start...");
	}
	
	private void middle() {
		System.out.println("Middle...");
	}
	
	private void end() {
		System.out.println("End...");
	}
	
}
