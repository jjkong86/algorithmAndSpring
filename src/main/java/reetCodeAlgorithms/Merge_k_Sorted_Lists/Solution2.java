package reetCodeAlgorithms.Merge_k_Sorted_Lists;

import java.util.Arrays;

import reetCodeAlgorithms.ListNode;

// 정렬된 리스트를 반환
// 리스트를 구성하면서 정렬함
class Solution2 {
	ListNode sortedNode = null, res = sortedNode;

	public ListNode mergeKLists(ListNode[] lists) {
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			while (node != null) {
				if (sortedNode == null) {
					sortedNode = new ListNode(node.val);
					res = sortedNode;
				} else {
					sortNode(new ListNode(node.val));
				}
				node = node.next;
			}
		}
		return res;
	}

	public void sortNode(ListNode target) {
		while (sortedNode != null && sortedNode.next != null) {
			if (sortedNode.next.val < target.val) {
				sortedNode = sortedNode.next;
			} else {
				break;
			}
		}

		if (sortedNode.val > target.val) {
			target.next = sortedNode;
			res = sortedNode = target;
		} else {
			ListNode next = sortedNode.next;
			sortedNode.next = target;
			target.next = next;
			sortedNode = res;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 23, 4, 5 };
		System.out.println(Arrays.stream(array).max().getAsInt());

	}
}
