package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode46 {
	// �������
	public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
		// ��������������
		if (first == n)
			res.add(new ArrayList<Integer>(output));
		for (int i = first; i < n; i++) {
			// ��̬ά������
			Collections.swap(output, first, i);
			// �����ݹ�����һ����
			backtrack(n, output, res, first + 1);
			// ��������
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

	// �������
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
