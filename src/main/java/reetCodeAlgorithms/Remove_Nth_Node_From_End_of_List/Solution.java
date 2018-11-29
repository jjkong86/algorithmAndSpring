package reetCodeAlgorithms.Remove_Nth_Node_From_End_of_List;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //hean.length - n + 1
        // 1>2>3>4>5 n=3 --> 5-3+1
        
		 //hean.length - n + 1
        // 1>2>3>4>5 n=3 --> 5-3+1
        
        ListNode dummy = head;
        ListNode retListNode = new ListNode(0);
        ListNode ret = retListNode;
        		
        int length = 0;
        while (dummy != null) {
            length ++;
            dummy = dummy.next;
        }
        int saveLength = 0;
        while (head != null) {
            saveLength ++;
            if (saveLength == length - n + 1) {
                head = head.next;
                continue;
            }
            ret.next = new ListNode(head.val);
            ret = ret.next;
            head = head.next;
        }
        return retListNode.next;
        
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(3);
		ListNode l14 = new ListNode(4);
		ListNode l15 = new ListNode(5);
		
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		
		int n = 2;
		
		ListNode result = s.removeNthFromEnd(l11, n);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}