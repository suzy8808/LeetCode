package dollar.kimi.leetcode;

public class LeetCode198 {
	// ¶¯Ì¬¹æ»®
	public int rob(int[] nums) {
		int current = 0;
		int pre = 0;
		for (int x : nums) {
			int temp = current;
			current = Math.max(current, pre + x);
			pre = temp;
		}
		return current;

	}

}
