package dollar.kimi.leetcode;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode98 {
	public boolean isValidBST(TreeNode root) {
		return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean help(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;
		if (minValue >= root.val || maxValue <= root.val)
			return false;
		return help(root.left, minValue, root.val) && help(root.right, root.val, maxValue);

	}

}
