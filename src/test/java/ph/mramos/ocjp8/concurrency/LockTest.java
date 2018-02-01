package ph.mramos.ocjp8.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class LockTest {

	@Test
	public void testReentrantLock() throws InterruptedException {
		Lock lock = new ReentrantLock();
		System.out.println("Start");
		new Thread(new ReentrantLockRunnable(lock, "Thread1")).start();
		new Thread(new ReentrantLockRunnable(lock, "Thread2")).start();
		Thread.sleep(3000);
		System.out.println("Finish");
	}
	
	@Test
	public void testReadWriteReentrantLock() throws InterruptedException {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		System.out.println("Start");
		new Thread(new ReentrantLockRunnable(lock.writeLock(), "Thread0")).start();
		new Thread(new ReentrantLockRunnable(lock.readLock(), "Thread1")).start();
		new Thread(new ReentrantLockRunnable(lock.readLock(), "Thread2")).start();
		new Thread(new ReentrantLockRunnable(lock.writeLock(), "Thread3")).start();
		Thread.sleep(4000);
		System.out.println("Finish");
	}

}
