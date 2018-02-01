package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConditionRunnable2 implements Runnable {

	private Lock lock;
	private String name;
	private Condition condition;

	public LockConditionRunnable2(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
		this.name = "thread2";
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

				condition.signal();
				System.out.println(name + ": Last");
			} finally {
				lock.unlock();
			}
		}
	}

}
