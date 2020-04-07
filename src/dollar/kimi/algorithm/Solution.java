package dollar.kimi.algorithm;

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

}
