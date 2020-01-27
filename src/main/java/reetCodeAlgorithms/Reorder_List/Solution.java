package reetCodeAlgorithms.Reorder_List;

import reetCodeAlgorithms.ListNode;

class Solution {

	class Pair {
		int count;
		ListNode node;

		Pair(int count, ListNode node) {
			this.count = count;
			this.node = node;
		}
	}

	// 1 > 2 > 3 > 4 > 5 > 6
	// 1 > 6 > 2 > 5 > 3 > 4
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		// 1 > 5 > 2, 2 > 4 > 3,
		ListNode save = head, tail = null;
		Pair pair = findTail(save);
		int count = pair.count / 2;
		tail = pair.node;

		while (count-- > 0) {
			ListNode headNext = head.next;
			ListNode tailNext = tail.next;
			if (count != 0 || count == 0 && pair.count % 2 != 0) {
				head.next = tail;
			}

			tail.next = headNext;
			head = headNext;
			tail = tailNext;
		}
		head.next = null;
	}

	private Pair findTail(ListNode head) {
		ListNode tail = null;
		int count = 0;
		while (head != null) {
			ListNode temp = new ListNode(head.val);
			temp.next = tail;
			tail = temp;
			head = head.next;
			count++;
		}

		return new Pair(count, tail);
	}

}
