package reetCodeAlgorithms.Reverse_Nodes_in_kGroup;

import java.util.Arrays;
import java.util.Random;

public class ReverseNodes {
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
  
		@Override
		public String toString() {
			return String.valueOf(val + (next != null ?" ["+next.val+"] " : ""));
		}
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
	
	public static String printNode(ListNode node) {
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.val + " ");
			node = node.next;
		}
		return sb.toString();
	}
	
	public static ListNode reverseNode(ListNode head, ListNode node) {
		ListNode copy = head;
		while (node != null && node.next != null) {
			ListNode tempNode = node.next; //node2
			head.next = tempNode;
			node.next = tempNode.next;
			node = node.next;
		}
		return copy.next;
	}
	
	public static void main(String[] args) {
		Random ran = new Random();
		int len = 10;
		int[] array = new int[len];
		for (int i = 0; i < len; i++) {
			array[i] = ran.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		ListNode node = buildNode(array);
		System.out.println(printNode(node));
		System.out.println(printNode(reverseNode(new ListNode(0), node)));
	}
	
}
