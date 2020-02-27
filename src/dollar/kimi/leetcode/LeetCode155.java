package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode155 {
//	自己实现的栈
//	private int[] value;
//	private int min;
//	private int maxCapacity = 16;//在leetcode这 这个参数越小越快
//	private int count;
//
//	/** initialize your data structure here. */
//	public LeetCode155() {
//		this.value = new int[maxCapacity];
//		this.min = Integer.MAX_VALUE;
//		this.count = -1;
//	}
//
//	public void push(int x) {
//		count++;
//		if (count == maxCapacity) {
//			moreCap();
//		}
//		value[count] = x;
//		if (count == 0)
//			min = x;
//		else if (min > x)
//			min = x;
//	}
//
//	public void pop() {
//		count--;
//		if (count < -1) {
//			throw new IllegalArgumentException();
//		}
//		if (min == value[count + 1]) {
//			int p = value[0];
//			for (int i = 1; i < count + 1; i++) {
//				if (value[i] < p) {
//					p = value[i];
//				}
//			}
//			min = p;
//		}
//	}
//
//	public int top() {
//		if (count < 0) {
//			throw new IllegalArgumentException();
//		}
//		return value[count];
//	}
//
//	public int getMin() {
//		if (count < 0) {
//			throw new IllegalArgumentException();
//		}
//		return min;
//	}
//
//	private void moreCap() {
//		maxCapacity = 1 << maxCapacity;
//		value = Arrays.copyOf(value, maxCapacity);
//	}

	// 数据栈
	private Stack<Integer> data;
	// 辅助栈
	private Stack<Integer> helper;

	/**
	 * initialize your data structure here.
	 */
	public LeetCode155() {
		data = new Stack<>();
		helper = new Stack<>();
	}

	// 思路 1：数据栈和辅助栈在任何时候都同步

	public void push(int x) {
		// 数据栈和辅助栈一定会增加元素
		data.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
	}

	public void pop() {
		// 两个栈都得 pop
		if (!data.isEmpty()) {
			helper.pop();
			data.pop();
		}
	}

	public int top() {
		if (!data.isEmpty()) {
			return data.peek();
		}
		throw new RuntimeException("栈中元素为空，此操作非法");
	}

	public int getMin() {
		if (!helper.isEmpty()) {
			return helper.peek();
		}
		throw new RuntimeException("栈中元素为空，此操作非法");
	}

}
