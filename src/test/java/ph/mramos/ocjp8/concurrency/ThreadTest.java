package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void testRunnable() {
		Runnable runnable = () -> {
			for (int i = 0; i < 100; i++) {	
				System.out.println("Test");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		for (int i = 0; i < 100; i++) {	
			System.out.println("Start");
		}
		
		for (int i = 0; i < 100; i++) {	
			System.out.println("End");
		}
	}
	
	@Test
	public void testExecute() {
		Runnable runnable1 = () -> {
			for (int i = 0; i < 100; i++) {	
				System.out.println("Test1");
			}
		};
		
		Runnable runnable2 = () -> {
			for (int i = 0; i < 100; i++) {	
				System.out.println("Test2");
			}
		};
		
		Runnable runnable3 = () -> {
			for (int i = 0; i < 100; i++) {	
				System.out.println("Test3");
			}
		};
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(runnable1);
		es.execute(runnable2);
		es.execute(runnable3);
		
		for (int i = 0; i < 100; i++) {	
			System.out.println("Start");
		}
		
		for (int i = 0; i < 100; i++) {	
			System.out.println("End");
		}
		
		es.shutdown();
	}
	
}
