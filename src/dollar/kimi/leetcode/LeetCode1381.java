package dollar.kimi.leetcode;

public class LeetCode1381 {
	int[] values;
	int size;
	int maxSize;

	public LeetCode1381(int maxSize) {
		if (maxSize == 0)
			return;
		values = new int[maxSize];
		size = 0;
		this.maxSize = maxSize;
	}

	public void push(int x) {
		if (size == maxSize)
			return;
		size++;
		values[size - 1] = x;
	}

	public int pop() {
		if (size == 0)
			return -1;
		size--;
		return values[size];
	}

	public void increment(int k, int val) {
		for (int i = 0; i < Math.min(size, k); i++) {
			values[i] += val;
		}
	}
}
