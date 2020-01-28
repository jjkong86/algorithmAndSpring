package reetCodeAlgorithms.Reorder_List;

import reetCodeAlgorithms.ListNode;

public class HalfResverse {
	// 중간부터 리트스가 역순으로 정렬
	private static void halfReverse(ListNode head) {
		ListNode slower = head, faster = head;

		while (faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}
		System.out.println(slower.toString());

		ListNode copy = slower, reverse = null;
		while (copy != null) {
			ListNode temp = copy.next;
			copy.next = reverse;
			reverse = copy;
			copy = temp;
		}
		System.out.println(head.toString());
		System.out.println(slower.toString());
	}

	public static void main(String[] args) {
		ListNode node = ListNode.buildNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		halfReverse(node);
	}
}
