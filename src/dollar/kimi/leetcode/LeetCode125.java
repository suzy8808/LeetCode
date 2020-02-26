package dollar.kimi.leetcode;

public class LeetCode125 {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() <= 1)
			return true;
		int j = s.length() - 1;
		out: for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
				i++;
				if (i >= s.length())
					break out;
				c = s.charAt(i);
			}
			c = Character.toLowerCase(c);

			char c2 = s.charAt(j);
			while (!Character.isDigit(c2) && !Character.isAlphabetic(c2)) {
				j--;
				if (j < 0)
					break out;
				c2 = s.charAt(j);
			}
			c2 = Character.toLowerCase(c2);
			if (c != c2)
				return false;
			if (j <= i)
				return true;
			j--;
		}
		return true;
	}

}
