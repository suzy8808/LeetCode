package dollar.kimi.leetcode;

import dollar.kimi.algorithm.ListNode;

public class LeetCode203 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		while (head != null && head.val == val) {
			head = head.next;
		}

		ListNode pre = head;
		ListNode cur = head;
		if (head != null)
			cur = head.next;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;
	}
}
