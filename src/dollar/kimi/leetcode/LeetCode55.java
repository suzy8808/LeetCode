package dollar.kimi.leetcode;

public class LeetCode55 {
	public boolean canJump(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (k < i)
				return false;
			k = Math.max(k, i + nums[i]);
		}
		return true;
	}
}
