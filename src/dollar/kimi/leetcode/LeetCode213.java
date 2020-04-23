package dollar.kimi.leetcode;

public class LeetCode213 {
	// 动态规划就是化解成子问题
	public int rob(int[] nums) {
		int cur1 = 0, pre1 = 0, cur2 = 0, pre2 = 0;
		if (nums.length == 1)
			return nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1) {
				int tmp = cur1;
				cur1 = Math.max(cur1, pre1 + nums[i]);
				pre1 = tmp;
			}
			if (i > 0) {
				int tmp = cur2;
				cur2 = Math.max(cur2, pre2 + nums[i]);
				pre2 = tmp;
			}
		}
		return Math.max(cur1, cur2);
	}
}
