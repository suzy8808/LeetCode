package dollar.kimi.leetcode;

import java.util.LinkedList;

public class LeetCode394 {
	public String decodeString(String s) {
		StringBuilder ans = new StringBuilder();
		LinkedList<StringBuilder> ansStack = new LinkedList<StringBuilder>();
		LinkedList<Integer> multiStack = new LinkedList<Integer>();
		int multi = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				multi = multi * 10 + c - '0';
			else if (c == '[') {
				multiStack.addLast(multi);
				ansStack.addLast(ans);
				multi = 0;
				ans = new StringBuilder();
			} else if (c == ']') {
				int tmp = multiStack.removeLast();
				StringBuilder ansTmp = ansStack.removeLast();
				for (int j = 0; j < tmp; j++) {
					ansTmp.append(ans);
				}
				ans = ansTmp;
			} else {
				ans.append(c);
			}
		}
		return ans.toString();
	}

}
