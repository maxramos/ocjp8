package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConditionRunnable implements Runnable {

	private Lock lock;
	private String name;
	private Condition condition;

	public LockConditionRunnable(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
		this.name = "thread1";
	}

	@Override
	public void run() {
		System.out.println(name + ": First");

		if (lock == null) {
			for (int i = 0; i < 100; i++) {
				System.out.println(name + ": " + i);
			}
			System.out.println(name + ": Last");
		} else {
			lock.lock();

			try {
				for (int i = 0; i < 100; i++) {
					System.out.println(name + ": " + i);
				}

				condition.await();
				System.out.println(name + ": Last");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} finally {
				lock.unlock();
			}
		}

	}

}
