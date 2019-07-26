package reetCodeAlgorithms.Reverse_Linked_List2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import reetCodeAlgorithms.ListNode;

class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //1 ≤ m ≤ n ≤ length of list
        int index = 1;
        ListNode copy = head;
        ListNode res = null;
        while (index <= n) {
            if (index++ >= m && index <= n) {
                ListNode temp = head.next;
                head.next = temp;
                res = head;
                head = temp;
            }
            if (index == n) res.next = head;
            head = head.next;
        }
        return copy;
    }
    
    public static class TestClass {
    	ListNode node = ListNode.buildNode(new int[] {1,2,3,4,5});
    	@Test
    	public void test1() {
    		assertThat(ListNode.buildNode(new int[] {1,4,3,2,5}), is(reverseBetween(node, 2, 4)));
    	}
    }
}
