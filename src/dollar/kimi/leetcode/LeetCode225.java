package dollar.kimi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {
	Queue<Integer> list;

	/** Initialize your data structure here. */
	public LeetCode225() {
		list = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		list.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		for (int i = 0; i < list.size() - 1; i++) {
			list.add(list.poll());
		}
		return list.poll();
	}

	/** Get the top element. */
	public int top() {
		for (int i = 0; i < list.size() - 1; i++) {
			list.add(list.poll());
		}
		int res = list.poll();
		list.add(res);
		return res;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return list.peek() == null ? true : false;
	}

	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}
