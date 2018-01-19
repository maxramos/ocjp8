package ph.mramos.ocjp8.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
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

		ExecutorService es = null;
		try {
			es = Executors.newSingleThreadExecutor();
			es.execute(runnable1);
			es.execute(runnable2);
			es.execute(runnable3);

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}
		} finally {
			es.shutdown();
		}
	}
	
	@Test
	public void testInvokeAll() throws InterruptedException {
		Callable<Void> callable1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test1");
			}
			
			return Void.TYPE.newInstance();
		};

		Callable<Void> callable2 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test2");
			}
			
			return Void.TYPE.newInstance();
		};

		Callable<Void> callable3 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test3");
			}
			
			return Void.TYPE.newInstance();
		};

		ExecutorService es = null;
		try {
//			es = Executors.newSingleThreadExecutor();
			es = Executors.newFixedThreadPool(3);
			es.invokeAll(Arrays.asList(callable1, callable2, callable3));

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}
		} finally {
			es.shutdown();
		}
	}

}
