package dollar.kimi.algorithm;

public class Temp {
	public int maxScore(String s) {
		int max = 0;
		int leftZero = 0;
		int rightOne = 0;
		char[] sc = s.toCharArray();
		for (char c : sc) {
			if (c == '1')
				rightOne++;
		}
		for (int i = 0; i < sc.length - 1; i++) {
			if (sc[i] == '0')
				leftZero++;
			else
				rightOne--;
			int sum = leftZero + rightOne;
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}

	public int maxScore(int[] cardPoints, int k) {
		int[] dp = new int[k + 1];
		dp[0] = 0;
		int left = 0;
		int right = cardPoints.length - 1;
		while (left < right) {
			for (int j = k; j >= 1; j--) {
				if (cardPoints[left] > cardPoints[right]) {
					dp[j] = dp[j - 1] + cardPoints[left++];
				} else {
					dp[j] = dp[j - 1] + cardPoints[right++];
				}

			}
		}
		return dp[k];
	}

}
