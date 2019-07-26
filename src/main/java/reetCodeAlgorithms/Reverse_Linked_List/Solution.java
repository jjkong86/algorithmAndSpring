package reetCodeAlgorithms.Reverse_Linked_List;

import reetCodeAlgorithms.ListNode;

class Solution {
    public static ListNode reverseList(ListNode head) {
        //재귀적으로 파고 들어가서 연결하면?
        
        ListNode res = null;
        while (head != null) {
        	ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }
    
    public static void main(String[] args) {
		ListNode node = ListNode.buildNode(new int[] {1,2,3,4,5});
		ListNode res = reverseList(node);
		System.out.println(res.val);
	}
}
