package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int pre = 0, count = 0;
		map.put(0, 1);
		for (int num : nums) {
			pre += num;
			if (map.containsKey(pre - k)) {
				count += map.get(pre - k);
			}
			map.put(pre, map.getOrDefault(pre, 0) + 1);
		}
		return count;
	}
}
