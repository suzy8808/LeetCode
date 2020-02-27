package dollar.kimi.leetcode;

import java.util.HashSet;
import java.util.Set;

import dollar.kimi.algorithm.ListNode;

public class LeetCode160 {
	// Hash 垃圾太慢
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.contains(headB))
				return headB;
			headB = headB.next;
		}

		return null;
	}

	// 双指针 还能这么搞 pA到头到B pB到头到A
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode pA = headA;
		ListNode pB = headB;

		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;

		}
		return pA;
	}
}
