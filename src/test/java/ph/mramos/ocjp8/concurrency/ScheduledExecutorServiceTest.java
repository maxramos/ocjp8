package ph.mramos.ocjp8.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ScheduledExecutorServiceTest {

	@Test
	public void testScheduleAtFixedRate() throws InterruptedException {
		Runnable runnable = () -> {
			System.out.println("Time: " + LocalDateTime.now());
		};

		ScheduledExecutorService es = null;
		try {
			es = Executors.newSingleThreadScheduledExecutor();
			System.out.println("Start: " + LocalDateTime.now());
			ScheduledFuture<?> future = es.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);
			System.out.println("Delay: " + future.getDelay(TimeUnit.SECONDS));
			Thread.sleep(180000);
			System.out.println("End: " + LocalDateTime.now());
		} finally {
			if (es != null) {
				es.shutdownNow();
			}
		}
	}
	
	@Test
	public void testScheduleWithFixedDelay() throws InterruptedException {
		Runnable runnable = () -> {
			System.out.println("Time: " + LocalDateTime.now());
		};

		ScheduledExecutorService es = null;
		try {
			es = Executors.newSingleThreadScheduledExecutor();
			System.out.println("Start: " + LocalDateTime.now());
			ScheduledFuture<?> future = es.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.MINUTES);
			System.out.println("Delay: " + future.getDelay(TimeUnit.SECONDS));
			Thread.sleep(180000);
			System.out.println("End: " + LocalDateTime.now());
		} finally {
			if (es != null) {
				es.shutdownNow();
			}
		}
	}
	
}
