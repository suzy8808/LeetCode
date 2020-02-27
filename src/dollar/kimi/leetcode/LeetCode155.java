package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode155 {
//	�Լ�ʵ�ֵ�ջ
//	private int[] value;
//	private int min;
//	private int maxCapacity = 16;//��leetcode�� �������ԽСԽ��
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

	// ����ջ
	private Stack<Integer> data;
	// ����ջ
	private Stack<Integer> helper;

	/**
	 * initialize your data structure here.
	 */
	public LeetCode155() {
		data = new Stack<>();
		helper = new Stack<>();
	}

	// ˼· 1������ջ�͸���ջ���κ�ʱ��ͬ��

	public void push(int x) {
		// ����ջ�͸���ջһ��������Ԫ��
		data.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
	}

	public void pop() {
		// ����ջ���� pop
		if (!data.isEmpty()) {
			helper.pop();
			data.pop();
		}
	}

	public int top() {
		if (!data.isEmpty()) {
			return data.peek();
		}
		throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
	}

	public int getMin() {
		if (!helper.isEmpty()) {
			return helper.peek();
		}
		throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
	}

}
