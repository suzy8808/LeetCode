package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dollar.kimi.algorithm.TreeNode;

public class LeetCode144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				list.add(cur.val);
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;

		}
		return list;
	}
}
