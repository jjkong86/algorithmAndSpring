package reetCodeAlgorithms.Palindrome_Linked_List;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void buildNode(ListNode node, int[] array, int index) {
		if (array.length > index) {
		ListNode nextNode = new ListNode(array[index++]);
		node.next = nextNode;
		node = node.next;
		buildNode(node, array, index);
		}
	}
	
    public boolean isPalindrome(ListNode head) {
        // palindrome : 회분
        // 1, 2, 3, 2, 1
    	if (head == null) return true;
    	ListNode fast = head, slow = head;
    	Stack<Integer> stack = new Stack<>();
    	stack.push(slow.val);
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		if (fast != null) {
    			stack.push(slow.val);
    		}
    	}
    	
    	while (slow != null) {
    		if (slow.val != stack.pop()) {
    			return false;
    		}
    		slow = slow.next;
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = new int[] {1,2,3,2,1};
		ListNode node = new ListNode(0);
		buildNode(node, array, 0);
		node = node.next;
		System.out.println(s.isPalindrome(node));
	}
}
