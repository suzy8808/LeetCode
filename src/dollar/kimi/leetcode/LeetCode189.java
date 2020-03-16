package dollar.kimi.leetcode;

public class LeetCode189 {
	// 使用环状替换
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int cur = start;
			int pre = nums[cur];
			do {
				int next = (cur + k) % nums.length;
				int temp = nums[next];
				nums[next] = pre;
				pre = temp;
				cur = next;
				count++;
			} while (start != cur);
		}
	}

	// 使用反转
	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reserve(nums, 0, nums.length - 1);
		reserve(nums, 0, k - 1);
		reserve(nums, k, nums.length - 1);
	}

	private void reserve(int[] nums, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
