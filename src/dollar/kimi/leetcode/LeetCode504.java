package dollar.kimi.leetcode;

public class LeetCode504 {
	public String convertToBase7(int num) {
		if (num == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		if (num < 0) {
			num = -num;
			flag = false;
		}
		while (num > 0) {
			sb.append(num % 7);
			num /= 7;
		}
		return flag ? sb.reverse().toString() : "-" + sb.reverse().toString();
	}

}
