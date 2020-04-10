package dollar.kimi.leetcode;

import java.util.List;
import java.util.Stack;

public class LeetCode636 {
	public int[] exclusiveTime(int n, List<String> logs) {
		Stack<Pair> stack = new Stack<LeetCode636.Pair>();
		int[] ans = new int[n];

		for (String log : logs) {
			String[] logItems = log.split(":");
			if ("start".equals(logItems[1])) {
				stack.add(new Pair(Integer.valueOf(logItems[0]), Integer.valueOf(logItems[2])));
			} else {
				Pair pop = stack.pop();
				int tmp = Integer.valueOf(logItems[2]) - pop.start + 1;
				ans[pop.functionId] += tmp;
				if (!stack.isEmpty())
					ans[stack.peek().functionId] -= tmp;

			}
		}
		return ans;
	}

	class Pair {
		int functionId;
		int start;

		public Pair(int functionId, int start) {
			super();
			this.functionId = functionId;
			this.start = start;
		}

	}
}
