package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1003 {
	public boolean isValid(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : S.toCharArray()) {
			if (c == 'c') {
				if (!stack.isEmpty()) {
					char p = stack.pop();
					if (p != 'b')
						return false;
					if (!stack.isEmpty()) {
						p = stack.pop();
						if (p != 'a')
							return false;
					} else
						return false;
				} else
					return false;
			} else {
				stack.add(c);
			}
		}
		return stack.isEmpty();

	}

	// 纯数组实现
	public static boolean isValid2(String S) {
		char[] s = S.toCharArray();
		char[] stack = new char[s.length];
		int index = 0;
		for (char cs : s) {
			if (cs != 'c') {
				stack[index++] = cs;
			} else {
				// 当前字符是c,如果前面不是"ab"串,肯定是false
				if (index < 2 || stack[--index] != 'b' || stack[--index] != 'a') {
					return false;
				}
			}
		}
		return index == 0;
	}

}
