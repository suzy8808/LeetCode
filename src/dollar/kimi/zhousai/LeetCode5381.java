package dollar.kimi.zhousai;

public class LeetCode5381 {
	public int[] processQueries(int[] queries, int m) {
		int[] P = new int[m];
		int[] ans = new int[queries.length];
		for (int i = 0; i < m; i++)
			P[i] = i + 1;

		for (int i = 0; i < queries.length; i++) {

			for (int j = 0; j < P.length; j++) {
				if (P[j] == queries[i]) {
					ans[i] = j;
					int tmp = P[j];
					for (int k = j - 1; k >= 0; k--)
						P[k + 1] = P[k];
					P[0] = tmp;
					P[0] = tmp;
					break;
				}
			}

		}
		return ans;
	}
}
