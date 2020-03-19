package dollar.kimi.leetcode;

public class LeetCode326 {
	// 整数限制法
	public boolean isPowerOfThree(int n) {
		return n > 0 && (1162261467 % n == 0);

	}
}
