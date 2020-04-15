package dollar.kimi.leetcode;

import java.util.Stack;

import dollar.kimi.algorithm.ListNode;

public class LeetCode445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();
		while (l1 != null) {
			stack1.add(l1);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.add(l2);
			l2 = l2.next;
		}
		ListNode ans = null;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int a = 0;
			int b = 0;
			if (!stack1.isEmpty())
				a = stack1.pop().val;
			if (!stack2.isEmpty())
				b = stack2.pop().val;
			int sum = a + b + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum < 10 ? 0 : 1;
			node.next = ans;
			ans = node;
		}
		if (carry != 0) {
			ListNode node = new ListNode(carry);
			node.next = ans;
			ans = node;
		}

		return ans;
	}
}
