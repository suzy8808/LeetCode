package dollar.kimi.leetcode;

import java.util.HashMap;

public class LeetCode169 {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int half = nums.length >>> 1;
		for (int num : nums) {
			if (map.containsKey(num)) {
				int sum = map.get(num) + 1;
				map.put(num, sum);

			} else {
				map.put(num, 1);
			}
			if (map.get(num) > half)
				return num;
		}
		return 0;
	}

	// Boyer-Moore ͶƱ�㷨
	public int majorityElement2(int[] nums) {
		int count = 0;
		Integer candidate = null;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count = candidate == num ? count + 1 : count - 1;
		}
		return candidate;
	}
}
