package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode739 {
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] ans = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				int sp = stack.pop();
				ans[sp] = i - sp;
			}
			stack.add(i);
		}
		return ans;
	}

	public int[] dailyTemperatures2(int[] T) {
		int length = T.length;
		int[] result = new int[length];

		// 从右向左遍历
		for (int i = length - 2; i >= 0; i--) {
			// j+= result[j]是利用已经有的结果进行跳跃
			for (int j = i + 1; j < length; j += result[j]) {
				if (T[j] > T[i]) {
					result[i] = j - i;
					break;
				} else if (result[j] == 0) { // 遇到0表示后面不会有更大的值，那当然当前值就应该也为0
					result[i] = 0;
					break;
				}
			}
		}

		return result;
	}

}
