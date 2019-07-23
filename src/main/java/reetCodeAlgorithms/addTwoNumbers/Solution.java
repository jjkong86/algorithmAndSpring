package reetCodeAlgorithms.addTwoNumbers;

import java.util.ArrayList;
import java.util.List;

import reetCodeAlgorithms.ListNode;

public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
        ListNode t1 = l1, t2 = l2, sumNode = new ListNode(0);
        sumNode = dummyHead;
        int carry = 0;
        
        while (t1 != null || t2 != null) {
            int x = t1.val;
            int y = t2.val;
            int sum = carry + x + y;
            carry = (int)sum/10;
            sumNode.next = new ListNode(sum % 10);
            sumNode = sumNode.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        
        if(carry > 0) {
        	sumNode.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(6);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(8);
		
		l11.next = l12;
		l12.next = l13;
		
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		ListNode l23 = new ListNode(9);
		
		l21.next = l22;
		l22.next = l23;
		
		ListNode result = addTwoNumbers(l11, l21);
		List<Object> reverse = new ArrayList<>();
		while (result != null) {
//			System.out.println(result.val);
			reverse.add(result.val);
			result = result.next;
		}
		String str = "[";
		for (int i = reverse.size()-1; i >= 0; i--) {
			str += reverse.get(i);
		}
		str+= "]";
		System.out.println(str);
	}
}
