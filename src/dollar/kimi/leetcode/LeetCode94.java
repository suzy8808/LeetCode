package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;
	}
}
