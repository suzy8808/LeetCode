package dollar.kimi.algorithm;

import java.util.Arrays;

public class Solution {
	// 滑动窗口的最大值
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0)
			return nums;
		int[] ans = new int[nums.length - k + 1];
		int maxIndex = -1;
		for (int i = 0; i < nums.length - k + 1; i++) {
			if (maxIndex == -1 || maxIndex < i) {
				maxIndex = i;
				for (int j = i; j < i + k; j++) {
					if (nums[maxIndex] < nums[j])
						maxIndex = j;
				}
			} else {
				if (nums[i + k - 1] > nums[maxIndex])
					maxIndex = i + k - 1;
			}
			ans[i] = nums[maxIndex];
		}
		return ans;
	}

	// 面试题 01.07. 旋转矩阵
	public void rotate(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - 1 - i; j++) {
				int x = i, y = j;
				int mtmp = 0;
				int mtmp2 = 0;
				do {
					if (x == i && y == j) {
						mtmp = matrix[y][N - 1 - x];
						matrix[y][N - 1 - x] = matrix[x][y];
					} else {
						mtmp2 = matrix[y][N - 1 - x];
						matrix[y][N - 1 - x] = mtmp;
						mtmp = mtmp2;
					}
					int tmp = y;
					y = N - 1 - x;
					x = tmp;
				} while (x != i || y != j);
			}
		}
	}

	// 面试题13. 机器人的运动范围
	public int movingCount(int m, int n, int k) {
		int[][] matrix = new int[m][n];
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isReachable(matrix, i, j, k))
					ans++;
			}
		}
		return ans;

	}

	private boolean isReachable(int[][] matrix, int i, int j, int k) {
		if (i == 0 && j == 0)
			return true;
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return false;
		int x = i, y = j;
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		while (y > 0) {
			sum += y % 10;
			y /= 10;
		}
		if (sum > k)
			return false;
		return isReachable(matrix, i - 1, j, k) || isReachable(matrix, i, j - 1, k);
	}

	public int movingCount2(int m, int n, int k) {
		boolean[][] visited = new boolean[m][n];
		return dfs(0, 0, 0, 0, visited, k);
	}

	public int dfs(int i, int j, int si, int sj, boolean[][] visited, int k) {
		if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || k < si + sj || visited[i][j])
			return 0;
		visited[i][j] = true;
		return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj, visited, k)
				+ dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8, visited, k);
	}

	public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
		int fmu1 = start1[0] - end1[0];
		int fmu2 = start2[0] - end2[0];
		int x1Max = Math.max(start1[0], end1[0]);
		int x1Min = Math.min(start1[0], end1[0]);
		int x2Max = Math.max(start2[0], end2[0]);
		int x2Min = Math.min(start2[0], end2[0]);
		int y1Max = Math.max(start1[1], end1[1]);
		int y1Min = Math.min(start1[1], end1[1]);
		int y2Max = Math.max(start2[1], end2[1]);
		int y2Min = Math.min(start2[1], end2[1]);
		if (fmu1 == 0 && fmu2 != 0) {

			if (start1[0] <= x2Max && start1[0] >= x2Min) {
				double a2 = ((double) (start2[1] - end2[1])) / fmu2 + 0.0;
				double b2 = ((double) (start2[0] * end2[1] - end2[0] * start2[1])) / fmu2 + 0.0;
				double y = a2 * start1[0] + b2;
				if (y <= y2Max && y >= y2Min) {
					return new double[] { start1[0], y };
				}
			}
			return new double[0];
		} else if (fmu1 != 0 && fmu2 == 0) {

			if (start2[0] <= x1Max && start2[0] >= x1Min) {
				double a1 = ((double) (start1[1] - end1[1])) / fmu1 + 0.0;
				double b1 = ((double) (start1[0] * end1[1] - end1[0] * start1[1])) / fmu1 + 0.0;
				double y = a1 * start2[0] + b1;
				if (y <= y1Max && y >= y1Min) {
					return new double[] { start2[0], y };
				}
			}
			return new double[0];
		} else if (fmu1 == 0 && fmu2 == 0) {
			if (start1[0] == start2[0]) {
				if ((y1Min <= y2Max && y1Min >= y2Min) || (y2Min <= y1Max && y2Min >= y1Min)) {
					return new double[] { start1[0], Math.max(y1Min, y2Min) };
				}
			}
			return new double[0];
		} else {
			double a1 = ((double) (start1[1] - end1[1])) / fmu1 + 0.0;
			double a2 = ((double) (start2[1] - end2[1])) / fmu2 + 0.0;
			double b1 = ((double) (start1[0] * end1[1] - end1[0] * start1[1])) / fmu1 + 0.0;
			double b2 = ((double) (start2[0] * end2[1] - end2[0] * start2[1])) / fmu2 + 0.0;
			if (a1 == a2) {
				if (b1 == b2) {
					if ((y1Min <= y2Max && y1Min >= y2Min)) {
						return new double[] { start1[0], y1Min };
					} else if ((y2Min <= y1Max && y2Min >= y1Min)) {
						return new double[] { start2[0], y2Min };
					}
				}
				return new double[0];
			} else {
				double[] ans = new double[2];
				ans[0] = (b2 - b1) / (a1 - a2);
				ans[1] = (a1 * b2 - a2 * b1) / (a1 - a2);
				int x = (int) ans[0];
				int y = (int) ans[1];

				if (x <= x1Max && x >= x1Min && x <= x2Max && x >= x2Min && y <= y1Max && y >= y1Min && y <= y2Max
						&& y >= y2Min) {
					return ans;
				}

				return new double[0];
			}
		}
	}

	// 面试题 08.11. 硬币
	public int waysToChange(int n) {
		int mod = 1000000007;
		int[] coins = new int[] { 25, 10, 5, 1 };
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int c = 0; c < 4; c++) {
			int coin = coins[c];
			for (int i = coin; i <= n; i++) {
				dp[i] = (dp[i] + dp[i - coin]) % mod;
			}
		}
		return dp[n];
	}

	// 面试题51. 数组中的逆序对
	public int reversePairs(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return 0;
		int[] copy = Arrays.copyOf(nums, len);
		int[] tmp = new int[len];
		return reversePairs(copy, 0, len - 1, tmp);

	}

	private int reversePairs(int[] nums, int left, int right, int[] tmp) {
		if (right == left)
			return 0;
		int mid = left + (right - left) / 2;
		int leftPairs = reversePairs(nums, left, mid, tmp);
		int rightPairs = reversePairs(nums, mid + 1, right, tmp);
		if (nums[mid] <= nums[mid + 1]) {
			return leftPairs + rightPairs;
		}
		int crossPairs = mergeAndCount(nums, left, mid, right, tmp);

		return crossPairs + leftPairs + rightPairs;
	}

	private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
		for (int i = left; i <= right; i++) {
			tmp[i] = nums[i];
		}
		int i = left;
		int j = mid + 1;
		int count = 0;
		for (int k = left; k <= right; k++) {
			if (i == mid + 1) {
				nums[k] = tmp[j];
				j++;
			} else if (j == right + 1) {
				nums[k] = tmp[i];
				i++;
			} else if (tmp[i] <= tmp[j]) {
				nums[k] = tmp[i];
				i++;
			} else {
				nums[k] = tmp[j];
				j++;
				count += mid - i + 1;
			}
		}

		return count;
	}

	// 面试题56 - I. 数组中数字出现的次数
	public int[] singleNumbers(int[] nums) {
		int ret = 0;
		int a = 0, b = 0;
		for (int n : nums)
			ret ^= n;
		int div = 1;
		while ((div & ret) == 0)
			div <<= 1;
		for (int n : nums) {
			if ((div & n) == div) {
				a ^= n;
			} else {
				b ^= n;
			}
		}
		return new int[] { a, b };
	}
}
