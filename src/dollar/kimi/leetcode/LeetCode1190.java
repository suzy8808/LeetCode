package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1190 {
	public String reverseParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] scs = s.toCharArray();
		for (int i = 0; i < scs.length; i++) {
			if (scs[i] == '(') {
				stack.add(i);
				scs[i] = ' ';
			}
			if (scs[i] == ')') {
				scs[i] = ' ';
				int j = stack.pop();
				reverse(scs, j + 1, i - 1);
			}
		}
		return String.valueOf(scs).replace(" ", "");
	}

	private void reverse(char[] scs, int start, int end) {
		while (start < end) {
			char tmp = scs[end];
			scs[end] = scs[start];
			scs[start] = tmp;
			start++;
			end--;
		}
	}
}
