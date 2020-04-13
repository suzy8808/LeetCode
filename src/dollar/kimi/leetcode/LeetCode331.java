package dollar.kimi.leetcode;

public class LeetCode331 {
	// ≤€Œª
	public boolean isValidSerialization(String preorder) {
		int slot = 1;
		for (String node : preorder.split(",")) {
			slot -= 1;
			if (slot < 0)
				return false;
			if (!node.equals("#"))
				slot += 2;
		}
		return slot == 0;
	}
}
