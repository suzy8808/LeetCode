package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode1209 {
	public String removeDuplicates(String s, int k) {

		StringBuilder sb = new StringBuilder();
		Stack<Pair> stack = new Stack<LeetCode1209.Pair>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || s.charAt(i) != stack.peek().ch) {
				stack.add(new Pair(1, s.charAt(i)));
			} else {
				if (++stack.peek().count == k) {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			Pair pop = stack.pop();
			for (int i = 0; i < pop.count; i++) {
				sb.append(pop.ch);
			}
		}

		return sb.reverse().toString();

	}

	class Pair {
		int count;
		char ch;

		public Pair(int count, char ch) {
			super();
			this.count = count;
			this.ch = ch;
		}

	}
}
