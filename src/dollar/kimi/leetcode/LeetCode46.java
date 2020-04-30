package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode46 {
	// 深度优先
	public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
		// 所有数都填完了
		if (first == n)
			res.add(new ArrayList<Integer>(output));
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);
			// 继续递归填下一个数
			backtrack(n, output, res, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList();

		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int num : nums)
			output.add(num);

		int n = nums.length;
		backtrack(n, output, res, 0);
		return res;
	}

	// 广度优先
	public List<List<Integer>> permute2(int[] nums) {
		Queue<LinkedList<Integer>> queue = new LinkedList();
		List<List<Integer>> res = new LinkedList();
		queue.add(new LinkedList<Integer>());
		while (!queue.isEmpty()) {
			LinkedList<Integer> list = queue.poll();
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					LinkedList<Integer> newList = new LinkedList<Integer>(list);
					newList.add(nums[i]);
					if (newList.size() == nums.length) {
						res.add(newList);
						continue;
					}
					queue.add(newList);
				}
			}
		}
		return res;
	}

}
