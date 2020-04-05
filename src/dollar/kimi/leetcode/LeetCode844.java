package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode844 {
	public boolean backspaceCompare(String S, String T) {
		Stack<Character> sStack = new Stack<>();
		Stack<Character> tStack = new Stack<>();
		char[] scs = S.toCharArray();
		char[] tcs = T.toCharArray();
		int i = 0, j = 0;
		while (i < scs.length || j < tcs.length) {
			if (i < scs.length) {
				if (scs[i] == '#') {
					if (!sStack.isEmpty())
						sStack.pop();
				} else
					sStack.add(scs[i]);
				i++;
			}
			if (j < tcs.length) {
				if (tcs[j] == '#') {
					if (!tStack.isEmpty())
						tStack.pop();
				} else
					tStack.add(tcs[j]);
				j++;
			}
		}
		if (sStack.size() != tStack.size())
			return false;
		for (int k = 0; k < sStack.size(); k++) {
			if (!sStack.pop().equals(tStack.pop()))
				return false;
		}
		return true;
	}
}
