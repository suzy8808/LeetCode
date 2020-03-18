package dollar.kimi.leetcode;

public class LeetCode190 {

	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int bit = n % 2;
			res *= 2;
			res += bit;
			n /= 2;
		}
		int p = Integer.MAX_VALUE;
		return res;
	}

	// you need treat n as an unsigned value
	public int reverseBits2(int n) {
		int ans = 0;
		for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
			ans += (n & 1) << bitsSize;
		}
		return ans;
	}
}
