package dollar.kimi.algorithm;

import java.util.Stack;

//面试题 03.04. 化栈为队
public class MyQueue {

	private Stack<Integer> stack;
	private Stack<Integer> helper;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack = new Stack<>();
		helper = new Stack<>();
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
