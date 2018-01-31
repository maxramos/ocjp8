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

	@Test
	public void testWaitNotify() throws InterruptedException {
		Object obj = new Object();
		System.out.println("Start");

		if (obj == null) {
			Thread thread = new Thread(new SimpleRunnable(obj));
			thread.start();
			Thread.sleep(2000);
			System.out.println("Finish");
		} else {
			synchronized (obj) {
				Thread thread = new Thread(new SimpleRunnable(obj));
				thread.start();
				Thread.sleep(2000); // does not relinquish the lock.
				obj.wait(); // this will relinquish the lock and will wait for a notify.
				System.out.println("Finish");
			}
		}

		Thread.sleep(4000);
	}

	@Test
	public void testInterrupt() throws InterruptedException {
		System.out.println("Start");
		Thread thread = new Thread(new SimpleRunnable(null));
		thread.start();
		thread.interrupt(); // interrupt the sleep in the other thread.
		System.out.println("Finish");
		Thread.sleep(4000);
	}

	@Test
	public void testJoin() throws InterruptedException {
		System.out.println("Start");
		Thread thread = new Thread(new SimpleRunnable(null));
		thread.start();
		thread.join(); // wait for the other thread to finish.
		System.out.println("Finish");
		Thread.sleep(4000);
	}

}
