package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode856 {
	public int scoreOfParentheses(String S) {
		Stack<Character> stack = new Stack<Character>();
		int ans = 0;
		char[] scs = S.toCharArray();
		for (int i = 0; i < scs.length; i++) {
			if (scs[i] == '(')
				stack.add(scs[i]);
			if (scs[i] == ')') {
				stack.pop();
				if (scs[i - 1] == '(') {
					int sum = 1;
					sum *= Math.pow(2, stack.size());
					ans += sum;
				}
			}
		}
		return ans;
	}
}
