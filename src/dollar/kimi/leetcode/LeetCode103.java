package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Stack<TreeNode> leftStack = new Stack<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root != null)
			leftStack.add(root);
		while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
			List<Integer> subList = new ArrayList<Integer>();
			while (!leftStack.isEmpty()) {
				TreeNode pLNode = leftStack.pop();
				subList.add(pLNode.val);
				if (pLNode.left != null)
					rightStack.add(pLNode.left);
				if (pLNode.right != null)
					rightStack.add(pLNode.right);
			}
			if (subList.size() > 0)
				list.add(subList);
			subList = new ArrayList<Integer>();
			while (!rightStack.isEmpty()) {
				TreeNode pRNode = rightStack.pop();
				subList.add(pRNode.val);
				if (pRNode.right != null)
					leftStack.add(pRNode.right);
				if (pRNode.left != null)
					leftStack.add(pRNode.left);
			}
			if (subList.size() > 0)
				list.add(subList);
		}
		return list;
	}
}
