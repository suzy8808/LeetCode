package dollar.kimi.algorithm;

public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode getListNodeFromArr(int[] arr) {
		if (arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode p = head;
		for (int i = 1; i < arr.length; i++) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		return head;
	}
}
