package dollar.kimi.algorithm;

import java.util.Stack;

class BSTIterator {

	TreeNode root;
	Stack<Integer> stack;

	public BSTIterator(TreeNode root) {
		this.root = root;
		stack = new Stack<Integer>();
		pushStack(root);
	}

	void pushStack(TreeNode root) {
		if (root == null)
			return;
		pushStack(root.right);
		stack.push(root.val);
		pushStack(root.left);
	}

	/** @return the next smallest number */
	public int next() {
		return stack.pop();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
}
