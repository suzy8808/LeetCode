package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode95 {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> allTrees = new ArrayList<TreeNode>();
		if (start > end) {
			allTrees.add(null);
			return allTrees;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> rs = generateTrees(i + 1, end);
			List<TreeNode> ls = generateTrees(start, i - 1);
			for (TreeNode r : rs) {
				for (TreeNode l : ls) {
					TreeNode node = new TreeNode(i);
					node.right = r;
					node.left = l;
					allTrees.add(node);
				}
			}
		}
		return allTrees;
	}
}
