package reetCodeAlgorithms.Reorder_List;

import reetCodeAlgorithms.ListNode;

class Solution {
	public void reorderList(ListNode head) {
		ListNode save = head;
		ListNode tail = findTail(head);
		ListNode prevNode = null;
		while (tail != prevNode) {
			prevNode = head;
			ListNode headNext = head.next;
			ListNode tailNext = tail.next;
			head.next = tail;
			if (tail.next == head) {
				tail.next = null;
				head = save;
				break;
			}
			tail.next = head.next;
			head = headNext;
			tail = tailNext;
		}
		head = save;
	}

	private ListNode findTail(ListNode head) {
		ListNode res = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = res;
			res = head;
			head = next;
		}
		return res;
	}
}
