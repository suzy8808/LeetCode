package dollar.kimi.leetcode;

public class LeetCode151 {
	public String reverseWords(String s) {
		String arr[] = s.split(" ");
		StringBuilder sb = new StringBuilder("");
		for (int i = arr.length - 1; i >= 0; i--) {
			if ("".equals(arr[i])) {
				continue;
			}
			sb.append(arr[i]).append(" ");
		}
		String res = sb.toString();
		if ("".equals(res)) {
			return res;
		}
		return res.substring(0, res.length() - 1);
	}
}
