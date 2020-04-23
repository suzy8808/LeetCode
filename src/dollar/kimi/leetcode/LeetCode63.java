package dollar.kimi.leetcode;

public class LeetCode63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else if (i == 0 && j == 0) {
					dp[i][j] = obstacleGrid[0][0] == 1 ? 0 : 1;
				} else {
					int a = i - 1 < 0 ? 0 : dp[i - 1][j];
					int b = j - 1 < 0 ? 0 : dp[i][j - 1];
					dp[i][j] = a + b;
				}

			}
		}
		return dp[m - 1][n - 1];
	}
}
