package ph.mramos.ocjp8.concurrency;

public class SimpleRunnable implements Runnable {

	private Object obj;

	public SimpleRunnable(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		if (obj == null) {
			System.out.println("First");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Last");

		} else {
			synchronized (obj) {
				System.out.println("First");

				if (obj != null) {
					obj.notify();
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				System.out.println("Last");
			}
		}
	}

}
