package dollar.kimi.leetcode;

public class LeetCode1025 {
	public boolean divisorGame(int N) {
		if (N == 1)
			return false;
		boolean[] dp = new boolean[N + 1];
		dp[2] = true;
		for (int i = 3; i < N + 1; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					if (dp[i - j] == false)
						dp[i] = true;
				}
			}
		}
		return dp[N];
	}
}
