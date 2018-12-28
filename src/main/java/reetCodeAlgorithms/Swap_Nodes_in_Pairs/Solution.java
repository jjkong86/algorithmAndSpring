package reetCodeAlgorithms.Swap_Nodes_in_Pairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		//값은 변경 할 수 없다고 했음 -> 노드의 연결을 바꿔주면 될듯
        //머리값을 반환
		//1234 -> 2143
		if(head == null || head.next == null)
            return head;
        ListNode newNode = swapPairs(head.next.next); // 1,3
        System.out.println(head.next.val);
        ListNode second = head.next; // 4, 2
        System.out.println(head.val);
        second.next = head; // 3, 1
        if(newNode != null) System.out.println(newNode.val);
        head.next = newNode; // 3,1
        return second;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(3);
		ListNode l14 = new ListNode(4);

		l11.next = l12;
		l12.next = l13;
		l13.next = l14;

		ListNode result = s.swapPairs(l11);

		String str = "[";
		while (result != null) {
			str += result.val;
			result = result.next;

		}
		str+= "]";
		System.out.println(str);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}
