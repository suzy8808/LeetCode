package dollar.kimi.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && num > nums[stack.peek()]) {
				ans[stack.pop()] = num;
			}
			// 重复的不要入栈
			if (i < n)
				stack.add(i);
		}
		return ans;
	}
}
