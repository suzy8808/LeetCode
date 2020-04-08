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

	// ������ʵ��
	public static boolean isValid2(String S) {
		char[] s = S.toCharArray();
		char[] stack = new char[s.length];
		int index = 0;
		for (char cs : s) {
			if (cs != 'c') {
				stack[index++] = cs;
			} else {
				// ��ǰ�ַ���c,���ǰ�治��"ab"��,�϶���false
				if (index < 2 || stack[--index] != 'b' || stack[--index] != 'a') {
					return false;
				}
			}
		}
		return index == 0;
	}

}
