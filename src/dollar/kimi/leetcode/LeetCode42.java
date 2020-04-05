package dollar.kimi.leetcode;

import java.util.Stack;

public class LeetCode42 {
	// stack
	public int trap(int[] height) {
		int ans = 0, current = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (current < height.length) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty())
					break;
				int distance = current - stack.peek() - 1;
				int hei = Math.min(height[current], height[stack.peek()]) - height[top];
				ans += distance * hei;
			}
			stack.add(current++);
		}
		return ans;
	}

	// left right max
	public int trap2(int[] height) {
		if (height.length == 0)
			return 0;
		int ans = 0;
		int len = height.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		leftMax[0] = height[0];
		for (int i = 1; i < len; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i - 1]);
		}
		rightMax[len - 1] = height[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i + 1]);
		}

		for (int i = 0; i < len; i++) {
			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return ans;
	}
}
