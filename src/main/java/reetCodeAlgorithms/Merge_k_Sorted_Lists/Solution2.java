package reetCodeAlgorithms.Merge_k_Sorted_Lists;

import java.util.StringJoiner;

import reetCodeAlgorithms.ListNode;

public class Solution2 {
	public ListNode mergeKLists(ListNode[] lists) {
		// 정렬된 리스트를 반환
		ListNode sortedNode = null, res = null;

		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			// print(node);
			while (node != null) {
				System.out.println("node :" + node.val);
				if (sortedNode == null) {
					sortedNode = node;
					res = sortedNode;
					node = node.next;
					continue;
				}
				sortNode(res, sortedNode, new ListNode(node.val));
				node = node.next;
			}
		}
		return res;
	}

	public void sortNode(ListNode res, ListNode sortedNode, ListNode node) {
		while (sortedNode != null) {
			// System.out.println("sortedNode :"+sortedNode.val);
			if (sortedNode.val < node.val) {
				sortedNode = sortedNode.next;
			} else {
				ListNode temp = sortedNode.next;
				ListNode tempNode = node.next;
				sortedNode.next = node;
				node.next = temp;
				break;
			}
		}
		if (sortedNode == null) {
			sortedNode = node;
		}
		System.out.println(res.toString());
		sortedNode = res;
	}

	public void print(ListNode node) {
		StringJoiner sj = new StringJoiner(",");
		ListNode copy = node;
		while (copy != null) {
			sj.add(String.valueOf(copy.val));
			copy = copy.next;
		}
		System.out.println("print start" + sj.toString());
	}
}
