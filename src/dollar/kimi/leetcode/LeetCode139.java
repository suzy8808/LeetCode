package dollar.kimi.leetcode;

import java.util.HashSet;
import java.util.List;

public class LeetCode139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> wordSet = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
