package dollar.kimi.leetcode;

import java.util.HashSet;
import java.util.Set;

import dollar.kimi.algorithm.ListNode;

public class LeetCode141 {
	// Ë«Ö¸Õë
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head;
		while (true) {
			p1 = p1.next;
			p2 = p2.next;
			if (p2 == null)
				return false;
			p2 = p2.next;
			if (p2 == null)
				return false;
			if (p1 == p2)
				return true;
		}
	}

	// Hash
	public boolean hasCycle2(ListNode head) {
		if (head == null)
			return false;
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head))
				return true;
			else
				set.add(head);
			head = head.next;
		}
		return false;
	}
}
