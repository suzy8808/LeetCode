package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1249 {
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '(')
				stack.add(i);
			if (sb.charAt(i) == ')') {
				if (stack.isEmpty()) {
					sb.deleteCharAt(i);
					i--;
				} else
					stack.pop();
			}
		}
		while (!stack.isEmpty())
			sb.deleteCharAt(stack.pop());
		return sb.toString();
	}
}
