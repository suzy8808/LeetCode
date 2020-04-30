package dollar.kimi.package9;

public class PackageProblem {
	// 01背包问题 空间未优化
	public int ZeroOnePack(int[] costs, int[] values, int N, int V) {
		int[][] dp = new int[N + 1][V + 1];
		for (int i = 1; i <= N; i++) {
			for (int v = 1; v <= V; v++) {
				if (v >= costs[i]) {
					dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - costs[i]] + values[i]);
				} else {
					dp[i][v] = dp[i - 1][v];
				}
			}
		}
		return dp[N][V];
	}

	// 01背包问题 空间优化
	public int ZeroOnePack2(int[] costs, int[] values, int N, int V) {
		int[] dp = new int[V + 1];
		for (int i = 1; i <= N; i++) {
			for (int v = V; v >= 1; v--) {
				if (v >= costs[i]) {
					dp[v] = Math.max(dp[v], dp[v - costs[i]] + values[i]);
				}
			}
		}
		return dp[V];
	}

	// 完全背包问题
	public int CompletePack(int[] costs, int[] values, int N, int V) {
		int[] dp = new int[V + 1];
		for (int i = 1; i <= N; i++) {
			for (int v = 1; v <= N; v++) {
				if (v >= costs[i]) {
					dp[v] = Math.max(dp[v], dp[v - costs[i]] + values[i]);
				}
			}
		}
		return dp[V];
	}
}
