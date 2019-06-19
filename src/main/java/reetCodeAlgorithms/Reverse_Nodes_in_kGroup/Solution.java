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
        // n * k번째마다 바뀜
        if (k == 1) return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        
        findNode(headNode, head, k, 0);
        
        return headNode.next;
    }
    
    public void findNode(ListNode headNode, ListNode node, int k, int count) {
        if (node == null) return;
        
        if (k % count == 0) {
            headNode.next = nodeSwap(node, k, count);
            count = 0;
        } else {
            nodeSwap(node, k, count+1);
        }
    }
    
    public ListNode nodeSwap(ListNode node, int k, int count) {
        
    	return node;
    }
}
