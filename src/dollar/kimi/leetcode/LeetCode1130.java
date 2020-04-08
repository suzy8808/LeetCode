package dollar.kimi.leetcode;

public class LeetCode1130 {
	// DP�㷨������Ⱑ
	public int mctFromLeafValues(int[] arr) {
		int n = arr.length;
		// �����ĺ�����:
		// Ҫ֪����������;�����arr���飨0...n-1����ĵ�kλԪ�ص��������Ԫ�أ��������Լ�������������������ұ�Ԫ�ض�����������
		// ����ʱ�������������ֱ�ѡ�����ֵ�ĳ˻����Ǵ�ʱ�ĸ���Ҳ������Ŀ��˵�ķ�Ҷ�ڵ�
		// �������ǿ��Լٶ���i��jλ����С�Ϳ����ǣ��˿�kλ��������Ԫ�������ֵ�ĳ˻� + ������k���(i,k)����Сֵ + ������kλ�ұ�(k+1,j)����Сֵ
		// ����dp[i][j]=min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j])
		// ������leetcode1039һ����·
		// ��arr��i��j֮���Ԫ�����ֵ, ������max[i][j]��
		// �����i��j�ǿ�����ȵ�
		int[][] max = new int[n][n];
		for (int j = 0; j < n; j++) {
			int maxValue = arr[j];
			for (int i = j; i >= 0; i--) {
				maxValue = Math.max(maxValue, arr[i]);
				max[i][j] = maxValue;
			}
		}
		int[][] dp = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int i = j; i >= 0; i--) {
				// k��i��j֮����м�ĳ��ֵ,i<=k<j
				int min = Integer.MAX_VALUE;
				for (int k = i; k + 1 <= j; k++) {
					min = Math.min(min, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
					dp[i][j] = min;
				}
			}
		}
		return dp[0][n - 1];

	}
}
