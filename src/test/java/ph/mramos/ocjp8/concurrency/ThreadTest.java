package ph.mramos.ocjp8.concurrency;

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
	
}
