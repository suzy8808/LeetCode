package dollar.kimi.leetcode;

public class LeetCode453 {
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(nums[i], min);
		}
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] - min;
		}
		return count;
	}
}
