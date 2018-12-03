package reetCodeAlgorithms.Merge_Two_Sorted_Lists;


public class Solution {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/**
		 * Definition for singly-linked list.
		 * public class ListNode {
		 *     int val;
		 *     ListNode next;
		 *     ListNode(int x) { val = x; }
		 * }
		 */
		
		//두 리스트를 오름차순으로 merge
		//l1:[1,2,4], l2:[1,3,4] ->> [1], l1:[2,4], l2:[1,3,4] ->> [1,1], l1:[2,4], l2:[3,4] ->> ...
		//l1:[1], l2:[3] ->> l1.next = (l1.next, l2); ->> l1 = null -> return l2; ->> l1.next = l2;
		
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int numl1 = l1.val;
		int numl2 = l2.val;
		// l1 = [5,6,7];
		// l2 = [1,3,4]; 
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(4);
		
		l11.next = l12;
		l12.next = l13;
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		
		l21.next = l22;
		l22.next = l23;
		
		ListNode result = s.mergeTwoLists(l11, l21);

		String str = "[";
		while (result != null) {
			str += result.val;
			result = result.next;
			
		}
		str+= "]";
		System.out.println(str);
	}

}
