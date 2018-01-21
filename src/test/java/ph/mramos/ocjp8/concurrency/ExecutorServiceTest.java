package ph.mramos.ocjp8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorServiceTest {

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
			if (es != null) {				
				es.shutdown();
			}
		}
	}

	@Test
	public void testSubmitRunnable() throws InterruptedException, ExecutionException {
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
//			es = Executors.newSingleThreadExecutor();
			es = Executors.newFixedThreadPool(3);
			Future<?> future1 = es.submit(runnable1);
			Future<?> future2 = es.submit(runnable2);
			Future<?> future3 = es.submit(runnable3);

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}

			System.out.println("Result1: " + future1.get());
			System.out.println("Result2: " + future2.get());
			System.out.println("Result3: " + future3.get());
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}
	}

	@Test
	public void testSubmitCallable() throws InterruptedException, ExecutionException {
		Callable<String> callable1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test1");
			}

			return "Test1";
		};

		Callable<String> callable2 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test2");
			}

			return "Test2";
		};

		Callable<String> callable3 = () -> {
//			boolean test = true;
//			if (test) {
//				throw new RuntimeException();
//			}

			for (int i = 0; i < 100; i++) {
				System.out.println("Test3");
			}

			return "Test3";
		};

		ExecutorService es = null;
		try {
//			es = Executors.newSingleThreadExecutor();
			es = Executors.newFixedThreadPool(3);
			Future<String> future1 = es.submit(callable1);
			Future<String> future2 = es.submit(callable2);
			Future<String> future3 = es.submit(callable3);

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}

			System.out.println("Result1: " + future1.get());
			System.out.println("Result2: " + future2.get());
			System.out.println("Result3: " + future3.get());
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}
	}

	@Test
	public void testInvokeAll() throws InterruptedException {
		Callable<String> callable1 = () -> {
			for (int i = 0; i < 600; i++) {
				System.out.println("Test1");
			}

			return "Test1";
		};

		Callable<String> callable2 = () -> {
			for (int i = 0; i < 600; i++) {
				System.out.println("Test2");
			}

			return "Test2";
		};

		Callable<String> callable3 = () -> {
			for (int i = 0; i < 1; i++) {
				System.out.println("Test3");
			}

			return "Test3";
		};

		ExecutorService es = null;
		try {
//			es = Executors.newSingleThreadExecutor();
			es = Executors.newFixedThreadPool(3);
			List<Future<String>> futures = es.invokeAll(Arrays.asList(callable1, callable2, callable3));

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}

			futures.forEach(future -> {
				try {
					System.out.println("Result: " + future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}
	}

	@Test
	public void testInvokeAny() throws InterruptedException, ExecutionException {
		Callable<String> callable1 = () -> {
			for (int i = 0; i < 600; i++) {
				System.out.println("Test1");
			}

			return "Test1";
		};

		Callable<String> callable2 = () -> {
			for (int i = 0; i < 600; i++) {
				System.out.println("Test2");
			}

			return "Test2";
		};

		Callable<String> callable3 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Test3");
			}

			return "Test3";
		};

		ExecutorService es = null;
		try {
//			es = Executors.newSingleThreadExecutor();
			es = Executors.newFixedThreadPool(3);
			String result = es.invokeAny(Arrays.asList(callable1, callable2, callable3));

			for (int i = 0; i < 100; i++) {
				System.out.println("Start");
			}

			for (int i = 0; i < 100; i++) {
				System.out.println("End");
			}

			System.out.println("Result: " + result);
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}

		if (es.isShutdown()) {
			System.out.println("Shutdownned...");
		}
		
		if (es != null) {
			es.awaitTermination(5, TimeUnit.SECONDS);
			
			if (es.isTerminated()) {
				System.out.println("Terminated...");
			}
		}
	}
	
	@Test
	public void testFuture() throws InterruptedException, ExecutionException {
		Callable<String> callable = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println("Test1");
			}

			return "Test1";
		};

		ExecutorService es = null;
		try {
			es = Executors.newSingleThreadExecutor();
			Future<String> future = es.submit(callable);
			Thread.sleep(100);
			
			if (!future.isCancelled()) {
				System.out.println("Not yet cancelled...");
				future.cancel(true);
				System.out.println("Cancel triggered...");
			}
			
			if (future.isCancelled()) {
				System.out.println("Task cancelled...");
			}
			
			if (future.isDone()) {
				System.out.println("Task done...");
			}
			
			System.out.println("Result: " + future.get());
		} catch (CancellationException e) {
			System.out.println("Cancelled");
		} finally {
			if (es != null) {				
				es.shutdown();
			}
		}
	}

}
