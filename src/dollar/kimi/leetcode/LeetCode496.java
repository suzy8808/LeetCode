package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		for (int i = 0; i < nums1.length; i++) {
			int j = 0;
			while (nums1[i] != nums2[j])
				j++;
			while (j < nums2.length && nums1[i] >= nums2[j])
				j++;
			nums1[i] = j == nums2.length ? -1 : nums2[j];
		}
		return nums1;
	}

	// µ¥µ÷Õ»
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && stack.peek() < nums2[i])
				map.put(stack.pop(), nums2[i]);
			stack.add(nums2[i]);
		}
		while (!stack.isEmpty())
			map.put(stack.pop(), -1);
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.get(nums1[i]);
		}
		return nums1;
	}
}
