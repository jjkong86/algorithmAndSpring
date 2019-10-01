package reetCodeAlgorithms.Linked_List_Cycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
import reetCodeAlgorithms.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head) {
		// 각 리스트 노드의 주소값을 저장하고 마지막 리스트가 다른 리스트를 바라 보고 있는지 체크
		// slower, faster -> faster == slower 되면 cycle
		Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head, 1);
            head = head.next;
            if (map.containsKey(head)) return true;
        }
		return false;
	}
}
