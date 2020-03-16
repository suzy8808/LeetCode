package dollar.kimi.leetcode;

public class LeetCode665 {
	public boolean checkPossibility(int[] nums) {
		if (nums.length < 3) {
			return true;
		}
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				count++;
				if (count > 1) {
					break;
				}
				if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
					nums[i + 1] = nums[i];
				} else {
					nums[i] = nums[i + 1];
				}
			}
		}
		return count <= 1;

	}
}
