package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode682 {
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (String op : ops) {
			Integer val = 0;

			if (op.equals("+")) {
				int s1 = stack.pop();
				int s2 = stack.pop();
				stack.add(s2);
				stack.add(s1);
				val = s1 + s2;
				stack.add(val);
				res += val;
			} else if (op.equals("D")) {
				int s = stack.peek();
				val = s * 2;
				stack.add(val);
				res += val;
			} else if (op.equals("C")) {
				val = stack.pop();
				res -= val;
			} else {
				val = Integer.valueOf(op);
				stack.add(val);
				res += val;
			}
		}

		return res;
	}
}
