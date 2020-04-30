package dollar.kimi.leetcode;

import dollar.kimi.algorithm.ListNode;

public class LeetCode23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode head = lists[0];

		for (int i = 1; i < lists.length; i++) {
			ListNode p = head, pre = null;
			ListNode p2 = lists[i];
			while (p != null || p2 != null) {
				if (p == null) {
					if (pre == null)
						head = p2;
					else
						pre.next = p2;
					break;
				} else if (p2 == null) {
					break;
				} else if (p2.val > p.val) {
					pre = p;
					p = p.next;
				} else {
					ListNode next2 = p2.next;
					p2.next = p;
					if (pre != null) {
						pre.next = p2;
					} else {
						head = p2;
					}
					pre = p2;
					p2 = next2;
				}
			}
		}
		return head;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		if (left == right)
			return lists[left];
		int mid = left + (right - left) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoLists(l1, l2);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
