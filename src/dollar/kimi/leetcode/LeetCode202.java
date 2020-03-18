package dollar.kimi.leetcode;

public class LeetCode202 {
	private int doSquare(int n) {
		int sum = 0;
		while (n > 0) {
			int mod = n % 10;
			sum += mod * mod;
			n /= 10;
		}
		return sum;
	}

	// ¿ìÂıÖ¸Õë
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		do {
			slow = doSquare(slow);
			fast = doSquare(fast);
			fast = doSquare(fast);
		} while (slow != fast);
		return slow == 1;
	}
}
