package dollar.kimi.leetcode;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode235 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int pVal = p.val;
		int qVal = q.val;

		if (pVal > root.val && qVal > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}

	}

}
