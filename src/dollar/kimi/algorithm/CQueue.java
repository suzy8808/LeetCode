package dollar.kimi.algorithm;

import java.util.Stack;

//������09. ������ջʵ�ֶ���
public class CQueue {

	private Stack<Integer> stack;
	private Stack<Integer> helper;

	public CQueue() {
		stack = new Stack<Integer>();
		helper = new Stack<Integer>();
	}

	public void appendTail(int value) {
		stack.add(value);
	}

	public int deleteHead() {
		if (helper.isEmpty()) {
			while (!stack.isEmpty())
				helper.add(stack.pop());
		}
		if (helper.isEmpty())
			return -1;
		return helper.pop();
	}
}
