package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1047 {
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (Character c : S.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().equals(c)) {
				stack.pop();
				sb.deleteCharAt(sb.length() - 1);
			} else {
				stack.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
