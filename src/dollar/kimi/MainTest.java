package dollar.kimi;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {
	// ['MinStack','push','push','push','top','pop','getMin','pop','getMin','pop','push','top','getMin','push','top','getMin','pop','getMin']
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger i = new AtomicInteger(1);
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				while (i.get() <= 100) {
					synchronized (i) {
						if (i.get() % 2 == 1 && i.get() <= 100) {
							System.out.println(i.getAndIncrement());
						}
					}
				}

			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				while (i.get() <= 100) {
					synchronized (i) {
						if (i.get() % 2 == 0 && i.get() <= 100) {
							System.out.println(i.getAndIncrement());
						}
					}
				}

			}
		});
		a.start();
		b.start();
	}

}
