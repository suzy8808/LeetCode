package dollar.kimi.leetcode;

public class LeetCode45 {
	public int jump(int[] nums) {
		int i = 0;
		int step = 0;
		while (i < nums.length - 1) {
			step++;
			int steps = nums[i];
			int maxIndex = i;
			int nextIndex = i;
			for (int j = i + 1; j <= i + steps; j++) {
				if (j >= nums.length - 1) {
					return step;
				}
				if (maxIndex < j + nums[j]) {
					maxIndex = j + nums[j];
					nextIndex = j;
				}
			}
			i = nextIndex;
		}
		return step;
	}
}
