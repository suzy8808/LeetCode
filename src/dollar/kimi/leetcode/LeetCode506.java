package dollar.kimi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode506 {
	public String[] findRelativeRanks(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		Arrays.sort(nums);
		String[] res = new String[nums.length];
		String[] str = new String[] { "Gold Medal", "Silver Medal", "Bronze Medal" };
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1)
				res[map.get(nums[i])] = str[0];
			else if (i == nums.length - 2)
				res[map.get(nums[i])] = str[1];
			else if (i == nums.length - 3)
				res[map.get(nums[i])] = str[2];
			else
				res[map.get(nums[i])] = "" + (nums.length - i);
		}
		return res;
	}

	public String[] findRelativeRanks2(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		int[] arr = new int[max + 1];
		// 将arr中所有数都设为-1；
		for (int i = 0; i < max + 1; i++) {
			arr[i] = -1;
		}

		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] = i;
		}

		String[] res = new String[nums.length];
		int rank = 1;
		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] >= 0) {
				if (rank == 1) {
					res[arr[j]] = "Gold Medal";
				} else if (rank == 2) {
					res[arr[j]] = "Silver Medal";
				} else if (rank == 3) {
					res[arr[j]] = "Bronze Medal";
				} else {
					res[arr[j]] = rank + "";
				}
				rank++;
			}
		}

		return res;
	}
}
