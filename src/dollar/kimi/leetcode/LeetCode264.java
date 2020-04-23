package dollar.kimi.leetcode;

public class LeetCode264 {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		int i1 = 0, i2 = 0, i3 = 0;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(Math.min(dp[i1] * 2, dp[i2] * 3), dp[i3] * 5);
			if (dp[i] == dp[i1] * 2)
				i1++;
			if (dp[i] == dp[i2] * 3)
				i2++;
			if (dp[i] == dp[i3] * 5)
				i3++;
		}
		return dp[n - 1];
	}
}
