package dollar.kimi.leetcode;

public class LeetCode507 {
	public boolean checkPerfectNumber(int num) {
		if (num <= 1)
			return false;
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				sum += i;
				if (num / i != num)
					sum += num / i;
			}
		}
		return sum == num;
	}
}
