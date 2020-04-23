package dollar.kimi.leetcode;

public class LeetCode64 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = grid[i][j];
				else {
					int a = i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j];
					int b = j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1];
					dp[i][j] = Math.min(a, b) + grid[i][j];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
