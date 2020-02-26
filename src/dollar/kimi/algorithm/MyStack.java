package dollar.kimi.algorithm;

import java.util.Arrays;

public class MyStack {

	private Integer[] storage;
	private Integer capacity;
	private Integer count;
	private static final Integer GROW_FACTOR = 2;

	public MyStack() {
		this.storage = new Integer[8];
		this.capacity = 8;
		this.count = 0;
	}

	public MyStack(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("capacity is too small");
		this.storage = new Integer[capacity];
		this.capacity = capacity;
		this.count = 0;
	}

	public void push(int value) {
		count++;
		if (capacity == count) {
			ensureCapacity();
		}
		storage[count - 1] = value;
	}

	public int pop() {
		count--;
		if (count < 0)
			throw new IllegalArgumentException("this stack is empty");
		return storage[count];
	}

	public int peek() {
		if (count == 0) {
			throw new IllegalArgumentException("this stack is empty");
		}
		return storage[count];
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	private void ensureCapacity() {
		capacity = capacity * GROW_FACTOR;
		storage = Arrays.copyOf(storage, capacity);
	}

}
