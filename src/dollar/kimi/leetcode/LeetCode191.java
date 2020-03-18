package dollar.kimi.leetcode;

public class LeetCode191 {
	public int hammingWeight(int n) {
		int count = 0;
		for (int bitSize = 1; bitSize <= 32; bitSize++) {
			count += (n & 1) == 1 ? 1 : 0;
			n = n >>> 1;
		}
		return count;
	}
}
