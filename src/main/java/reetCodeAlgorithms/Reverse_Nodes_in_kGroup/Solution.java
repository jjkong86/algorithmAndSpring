package reetCodeAlgorithms.Reverse_Nodes_in_kGroup;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

		

class Solution {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        // k는 node보다 작거나 같음, 
        // 재귀적으로 파고 들어가서 리턴으로 노드를 보낸다음 연결 하면 ??
        if (k == 1) return head;
        return head;
    }
    
    private ListNode reverseNode(ListNode node, int count, int index) {
        if (index >= count) return node;
        
        node.next = reverseNode(node.next, count, index+1);
        return node;
    }
}
