package reetCodeAlgorithms;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		this.val = x; 
	}
	
	@Override
	public String toString() {
		return String.valueOf(val + (next != null ?" ["+next.val+"] " : ""));
	}
	
	public static ListNode buildNode(int[] array) {
		ListNode res = new ListNode(0);
		ListNode copy = res;
		for (int i = 0; i < array.length; i++) {
			ListNode temp = new ListNode(array[i]);
			res.next = temp;
			res = res.next;
		}
		return copy.next;
	}
}
