package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode167 {
	// 递归 慢的一比 不爽 n*logn
	public int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int i2 = 0;
		for (i = 0; i < numbers.length; i++) {
			i2 = getI2(numbers, target - numbers[i], i + 1, numbers.length - 1);
			if (i2 > 0)
				break;
		}
		if (i == numbers.length)
			return null;
		return new int[] { i + 1, i2 + 1 };
	}

	private int getI2(int[] numbers, int target, int i, int i2) {
		if (i > i2)
			return -1;
		int k = (i + i2) / 2;
		if (numbers[k] == target)
			return k;
		else if (numbers[k] > target)
			return getI2(numbers, target, i, k - 1);
		else
			return getI2(numbers, target, k + 1, i2);
	}

	// Hash
	public int[] twoSum2(int[] numbers, int target) {
		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i]))
				break;
			else
				map.put(target - numbers[i], i);

		}
		if (i == numbers.length)
			return null;
		return new int[] { map.get(numbers[i]) + 1, i + 1 };
	}

}
