package dollar.kimi.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
	// dp算法
	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
			}
		}
		// 左上角开始
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i - 1 >= 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
				}
				if (j - 1 >= 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
				}
			}
		}
		// 右上角开始
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i + 1 < m) {
					dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
				}
				if (j + 1 < n) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
				}
			}
		}
		return dp;

	}

	// 图的广度优先
	// 1 注意图节点不止一个
	// 2 图需要判断是否访问过
	public int[][] updateMatrix2(int[][] matrix) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int m = matrix.length, n = matrix[0].length;
		// -1代表没有访问过
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix[i][j] = -1;
				}
			}
		}

		int[] dx = new int[] { 0, 0, 1, -1 };
		int[] dy = new int[] { 1, -1, 0, 0 };
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int x = point[0];
			int y = point[1];
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (newX >= 0 && newY >= 0 && newX < m && newY < n && matrix[newX][newY] == -1) {
					matrix[newX][newY] = matrix[x][y] + 1;
					queue.offer(new int[] { newX, newY });
				}
			}
		}
		return matrix;

	}

}
