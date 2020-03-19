package dollar.kimi.algorithm;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		this.val = x;
	}

	// 数组生成树
	public static TreeNode getTreeFromArray(Integer[] nums) {
		return getTreeFromArray(nums, 0);
	}

	private static TreeNode getTreeFromArray(Integer[] nums, int deep) {
		if (deep >= nums.length)
			return null;
		if (nums[deep] == null)
			return null;
		TreeNode root = new TreeNode(nums[deep]);
		root.left = getTreeFromArray(nums, deep * 2 + 1);
		root.right = getTreeFromArray(nums, deep * 2 + 2);
		return root;
	}

	// 广度遍历
	public static Integer[] getBreadthArray(TreeNode root) {
		LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode pRoot = queue.remove();
			list.add(pRoot.val);
			if (pRoot.left != null)
				queue.add(pRoot.left);
			if (pRoot.right != null)
				queue.add(pRoot.right);
		}
		return list.toArray(new Integer[0]);

	}

	// 深度遍历
	public static Integer[] getDepthArray(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			TreeNode pRoot = stack.pop();
			list.add(pRoot.val);
			if (pRoot.right != null)
				stack.push(pRoot.right);
			if (pRoot.left != null)
				stack.push(pRoot.left);
		}
		return list.toArray(new Integer[0]);

	}

	// 反转二叉树
	public TreeNode invertTree(TreeNode root) {
		root = doInvert(root);
		return root;
	}

	private TreeNode doInvert(TreeNode root) {
		if (root == null)
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		doInvert(root.left);
		doInvert(root.right);
		return root;
	}
}
