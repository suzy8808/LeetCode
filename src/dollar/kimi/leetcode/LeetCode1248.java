package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

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

	public int numberOfSubarrays2(int[] nums, int k) {
		Map<Integer, Integer> preMap = new HashMap<Integer, Integer>();
		preMap.put(0, 1);
		int res = 0, sum = 0;
		for (int num : nums) {
			sum += num & 1;
			preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
			if (sum >= k) {
				res += preMap.getOrDefault(sum - k, 0);
			}
		}
		return res;
	}
}
