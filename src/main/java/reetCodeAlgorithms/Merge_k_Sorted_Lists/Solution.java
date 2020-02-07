package reetCodeAlgorithms.Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import reetCodeAlgorithms.ListNode;

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		//노드가 배열로옴 --> 각각 오름차순으로 정렬..
		//각 노드에서 다 꺼내옴?
		//노드에서 모든수를 배열에 넣고 정렬후 다시 노드에 넣어줌
		if(lists == null || lists.length == 0) return null;
		
		ListNode retNode = new ListNode(0);
		ListNode dummyNode = retNode;
		List<Integer> arrayList = new ArrayList<>();
		for (int i=0; i < lists.length; i++) {
			ListNode tempNode = new ListNode(0);
			tempNode = lists[i];
			while (tempNode != null) {
				int tempInt = tempNode.val;
				arrayList.add(tempInt);
				tempNode = tempNode.next;
			}
		}
		Collections.sort(arrayList);
		
		System.out.println(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			retNode.next = new ListNode(arrayList.get(i));
			retNode = retNode.next;
		}
		
		
		
		return dummyNode.next;
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
		
		
		ListNode[] list = new ListNode[2];
		list[0] = l11;
		list[1] = l21;
		
		ListNode result = s.mergeKLists(list);
		
		String str = "[";
		while (result != null) {
			str += result.val;
			result = result.next;
			
		}
		str+= "]";
		System.out.println(str);
	}

}

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		this.val = x; 
//	}
//}

