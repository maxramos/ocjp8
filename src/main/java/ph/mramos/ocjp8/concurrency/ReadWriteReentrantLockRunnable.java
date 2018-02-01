package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.locks.Lock;

public class ReadWriteReentrantLockRunnable implements Runnable {

	private Lock lock;
	private String name;

	public ReadWriteReentrantLockRunnable(Lock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run() {
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
