package dollar.kimi.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {
	public int singleNumber(int[] nums) {
		int a = 0;
		for (int num : nums) {
			a ^= num;
		}
		return a;
	}

	public int singleNumber2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num))
				set.remove(num);
			else
				set.add(num);
		}
		return set.iterator().next();
	}
}
