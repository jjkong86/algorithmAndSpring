package reetCodeAlgorithms.Middle_of_the_Linked_List;

import java.util.*;

import reetCodeAlgorithms.ListNode;
class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        
        return list.get(list.size()/2);
    }
    
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head, slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
