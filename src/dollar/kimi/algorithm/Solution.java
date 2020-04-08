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

}
