package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CyclicBarrierTest {

	@Test
	public void testCyclicBarrier() {
		CyclicBarrier cb1 = new CyclicBarrier(4);
		CyclicBarrier cb2 = new CyclicBarrier(4, () -> System.out.println("Ending..."));
		TaskManager tm = new TaskManager();
		
		ExecutorService es = null;
		try {
			es = Executors.newFixedThreadPool(4);
			
			for (int i = 0; i < 4; i++) {
//				es.submit(() -> tm.performTask());
				es.submit(() -> tm.performTask(cb1, cb2));
			}
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}
	}
	
}
