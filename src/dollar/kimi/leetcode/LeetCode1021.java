package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1021 {
	public String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<Character>();
		char[] scs = S.toCharArray();
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < scs.length; i++) {
			sb.append(scs[i]);
			if (scs[i] == '(')
				stack.add(scs[i]);
			if (scs[i] == ')')
				stack.pop();
			if (stack.isEmpty()) {
				sb.deleteCharAt(j);
				sb.deleteCharAt(sb.length() - 1);
				j = sb.length();
			}
		}
		return sb.toString();
	}

	public String removeOuterParentheses2(String S) {
		int count = 0;
		char[] scs = S.toCharArray();
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < scs.length; i++) {
			sb.append(scs[i]);
			if (scs[i] == '(')
				count++;
			if (scs[i] == ')')
				count--;
			if (count == 0) {
				sb.deleteCharAt(j);
				sb.deleteCharAt(sb.length() - 1);
				j = sb.length();
			}
		}
		return sb.toString();
	}
}
