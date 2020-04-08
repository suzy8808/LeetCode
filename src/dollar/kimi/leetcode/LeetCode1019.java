package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import dollar.kimi.algorithm.ListNode;

public class LeetCode1019 {
	public int[] nextLargerNodes(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		ListNode p = head;
		while (p != null) {
			list.add(p.val);
			p = p.next;
		}
		Integer[] arr = list.toArray(new Integer[0]);
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				ans[stack.pop()] = arr[i];
			}
			stack.add(i);
		}
		while (!stack.isEmpty())
			ans[stack.pop()] = 0;
		return ans;
	}

	public int[] nextLargerNodes2(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] data = new int[10000];
		int[] ans = new int[10000];
		int len = 0;
		ListNode p = head;
		while (p != null) {
			data[len++] = p.val;
			while (!stack.isEmpty() && data[stack.peek()] < p.val) {
				ans[stack.pop()] = p.val;
			}
			stack.add(len - 1);
			p = p.next;
		}
		ans = Arrays.copyOf(ans, len);
		return ans;
	}
}
