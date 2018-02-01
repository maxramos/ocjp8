package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.locks.Lock;

public class ReentrantLockRunnable implements Runnable {

	private Lock lock;
	private String name;

	public ReentrantLockRunnable(Lock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run() {
		if (lock == null) {
			for (int i = 0; i < 5; i++) {
				System.out.println(name + ": " + i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			lock.lock();

			try {
				for (int i = 0; i < 5; i++) {
					System.out.println(name + ": " + i);
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} finally {
				lock.unlock();
			}
		}
	}

}
