package dollar.kimi.leetcode;

public class LeetCode91 {
	public int numDecodings(String s) {
		if (s.startsWith("0"))
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		for (int i = 1; i < s.length() + 1; i++) {
			if (i == 1)
				dp[i] = 1;
			else {
				int tmp1 = Integer.valueOf(s.substring(i - 1, i));
				int tmp2 = Integer.valueOf(s.substring(i - 2, i));
				if (tmp2 <= 26 && tmp2 >= 10 && tmp1 > 0) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else if ((tmp2 > 26 || tmp2 < 10) && tmp1 > 0) {
					dp[i] = dp[i - 1];
				} else if (tmp2 <= 26 && tmp2 >= 10 && tmp1 == 0) {
					dp[i] = dp[i - 2];
				} else {
					dp[i] = 0;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
