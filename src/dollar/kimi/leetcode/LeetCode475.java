package dollar.kimi.leetcode;

import java.util.Arrays;

public class LeetCode475 {
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);

		int res = 0;

		for (int house : houses) {
			// 二分搜索当前 house 在 heaters 中的位置
			int index = binarySearch(heaters, house);

			if (index < 0) { // 说明没找到，index 等于当前的 house 应该在 heaters 的位置的负数
				// 计算出当前的 house 应该在 heaters 数组中的位置
				index = -(index + 1);
				// 计算当前 house 离左边最近的 heater 的距离
				int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
				// 计算当前 house 离右边最近的 heater 的距离
				int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

				// 当前 house 需要的 heater 的半径取 leftDist 和 rightDist 的最小值
				res = Math.max(res, Math.min(leftDist, rightDist));
			}
		}

		return res;
	}

	private int binarySearch(int[] heaters, int house) {
		int low = 0;
		int hight = heaters.length - 1;
		while (low <= hight) {
			int mid = (low + hight) >>> 1;

			if (heaters[mid] < house) {
				low = mid + 1;
			} else if (heaters[mid] > house) {
				hight = mid - 1;
			} else {
				return mid;
			}
		}
		return -(low + 1);
	}

	public int findRadius2(int[] houses, int[] heaters) {

		int max = 0;
		Arrays.sort(heaters);
		for (int i = 0; i < houses.length; i++) {
			int d = 0;
			int j = 0;
			while (j < heaters.length) {
				if (houses[i] == heaters[j]) {
					d = 0;
				} else if (houses[i] > heaters[j] && j == heaters.length - 1) {
					d = houses[i] - heaters[j];
				} else if (houses[i] > heaters[j] && houses[i] < heaters[j + 1]) {
					d = Math.min(heaters[j + 1] - houses[i], houses[i] - heaters[j]);
				} else if (houses[i] < heaters[j] && j == 0) {
					d = heaters[j] - houses[i];
				}
				j++;
			}
			if (max < d)
				max = d;
		}
		return max;

	}

}
