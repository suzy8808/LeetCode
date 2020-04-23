package dollar.kimi.leetcode;

public class LeetCode1248 {
	// l½éºõodd[i-1]~odd[i],r½éºõodd[i+k-1]~odd[i+k]
	// count=l*r
	public int numberOfSubarrays(int[] nums, int k) {
		int[] odd = new int[nums.length + 2];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & 1) == 1)
				odd[++len] = i;
		}
		if (len < k)
			return 0;
		odd[0] = -1;
		odd[++len] = nums.length;
		int ans = 0;
		for (int i = 1; i + k < len + 1; i++) {
			ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
		}
		return ans;
	}
}
