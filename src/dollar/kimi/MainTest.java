package dollar.kimi;

import dollar.kimi.algorithm.TreeNode;
import dollar.kimi.leetcode.LeetCode235;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		TreeNode root = TreeNode.getTreeFromArray(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		LeetCode235 leet = new LeetCode235();

		System.out.println(leet.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
	}

}
