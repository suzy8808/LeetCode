package dollar.kimi.leetcode;

public class LeetCode461 {
	public int hammingDistance(int x, int y) {
		x ^= y;
		int distance = 0;
		while (x != 0) {
			if ((x & 1) == 1)
				distance++;
			x = x >> 1;
		}
		return distance;
	}
}
