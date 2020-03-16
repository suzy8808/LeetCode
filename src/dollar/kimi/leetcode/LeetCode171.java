package dollar.kimi.leetcode;

public class LeetCode171 {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res *= 26;
			char c = s.charAt(i);
			res += c - 'A' + 1;

		}
		return res;
	}
}
