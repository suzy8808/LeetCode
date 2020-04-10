package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode22 {
	List<String> list = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		Stack<Character> stack = new Stack<Character>();
		doGenerateParenthesis(n, "", 0, true);
		return list;
	}

	private void doGenerateParenthesis(int n, String s, int size, boolean type) {
		if (type) {
			s += '(';
			size++;
		} else {
			s += ')';
			size--;
			n--;
		}

		if (size != 0) {
			if (size == n)
				doGenerateParenthesis(n, s, size, false);
			else {
				doGenerateParenthesis(n, s, size, true);
				doGenerateParenthesis(n, s, size, false);
			}
		} else {
			if (n == 0)
				list.add(s);
			else {
				doGenerateParenthesis(n, s, size, true);
			}
		}
	}

}
