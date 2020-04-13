package dollar.kimi.leetcode;

public class LeetCode887 {
	public int superEggDrop(int K, int N) {
		int[] dp = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			dp[i] = i;
		}

		for (int k = 2; k <= K; ++k) {
			int[] dp2 = new int[N + 1];
			int x = 1;
			for (int n = 1; n <= N; ++n) {
				while (x < n && Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x], dp2[n - x - 1]))
					x++;
				dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
			}
			dp = dp2;
		}
		return dp[N];
	}
}
