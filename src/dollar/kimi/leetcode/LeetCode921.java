package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode921 {
	public int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<Character>();
		int more = 0;
		for (char c : S.toCharArray()) {
			if (c == '(')
				stack.add(c);
			if (c == ')') {
				if (stack.isEmpty())
					more++;
				else
					stack.pop();

			}
		}
		return more + stack.size();
	}
}
