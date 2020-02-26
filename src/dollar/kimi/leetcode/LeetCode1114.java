package dollar.kimi.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode1114 {
	private AtomicInteger flag = new AtomicInteger(0);

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		flag.incrementAndGet();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (flag.get() != 1)
			;
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		flag.incrementAndGet();
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (flag.get() != 2)
			;
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
