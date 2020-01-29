package reetCodeAlgorithms.Reorder_List;

import org.junit.Test;

import reetCodeAlgorithms.ListNode;

public class HalfResverse {
	// 중간부터 리트스가 역순으로 정렬
	private static void halfReverse(ListNode head) {
		ListNode slower = head, faster = head;

		while (faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}

		ListNode copy = slower, reverse = null;
		while (copy != null) {
			ListNode temp = copy.next;
			copy.next = reverse;
			reverse = copy;
			copy = temp;
		}
		ListNode halfReverse = head;
		while (reverse != null) {
			ListNode headNext = head.next;
			ListNode reverseNext = reverse.next;
			head.next = reverse;
			reverse.next = headNext;
			head = headNext;
			reverse = reverseNext;
		}
		head = halfReverse;

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static class TestClass {

//		@Test
//		public void test1() {
//			ListNode node = ListNode.buildNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
//			halfReverse(node);
//		}

		@Test
		public void test2() {
			ListNode node = ListNode.buildNode(new int[] { 1, 2, 3, 4 });
			halfReverse(node);
		}
	}
}
