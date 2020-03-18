package dollar.kimi.leetcode;

public class LeetCode204 {
	// 太慢了
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			count += isPrimeNumber(i) ? 1 : 0;
		}
		return count;
	}

	private boolean isPrimeNumber(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// 厄拉多塞筛法
	public int countPrimes2(int n) {

		if (n < 2)
			return 0;
		int count = 0;
		boolean[] nums = new boolean[n];
		System.out.println(nums[0]);
		for (int i = 2; i * i < n; i++) {
			if (!nums[i]) {
				for (int j = i * i; j < n; j += i) {
					if (nums[j])
						continue;
					count++;
					nums[j] = true;
				}
			}
		}
		return n - count - 2;
	}

}
