package dollar.kimi.leetcode;

import java.util.List;

public class LeetCode120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int m = triangle.size();
		int[] dp = new int[m + 1];
		for (int i = m - 1; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
			}
		}
		return dp[0];
	}
}
