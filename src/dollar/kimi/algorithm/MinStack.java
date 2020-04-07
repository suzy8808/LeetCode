package dollar.kimi.algorithm;

import java.util.Stack;

//面试题 03.02. 栈的最小值
public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> helper;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Integer>();
		helper = new Stack<Integer>();
	}

	public void push(int x) {
		stack.add(x);
		if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		}
	}

	public void pop() {
		int x = stack.pop();
		if (stack.isEmpty())
			helper.clear();
		else if (helper.peek() == x)
			helper.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return helper.peek();
	}
}
