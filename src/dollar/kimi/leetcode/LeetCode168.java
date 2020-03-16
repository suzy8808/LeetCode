package dollar.kimi.leetcode;

public class LeetCode168 {
	public String convertToTitle(int n) {
		if (n <= 0)
			return null;
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			n -= 1;
			int m = n % 26;
			char c = (char) ('A' + m);
			sb.append(c);
			n /= 26;
		}
		return sb.reverse().toString();

	}
}
