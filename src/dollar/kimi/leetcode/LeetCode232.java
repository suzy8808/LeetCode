package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode232 {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> helper = new Stack<Integer>();

	/** Initialize your data structure here. */
	public LeetCode232() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack.add(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (helper.isEmpty()) {
			while (!stack.isEmpty())
				helper.add(stack.pop());
		}
		return helper.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (helper.isEmpty()) {
			while (!stack.isEmpty())
				helper.add(stack.pop());
		}
		return helper.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty() && helper.isEmpty();
	}
}
