package dollar.kimi.leetcode;

public class LeetCode459 {
	// Ì«Âý
	public boolean repeatedSubstringPattern(String s) {
		if (s.length() == 0)
			return false;
		for (int i = 1; i <= s.length() / 2; i++) {
			String temp = s.replace(s.substring(0, i), "");
			if (temp.length() == 0)
				return true;
		}
		return false;
	}

	public boolean repeatedSubstringPattern2(String s) {
		String str = s + s;
		return str.substring(1, str.length() - 1).contains(s);
	}
}
