package codewars.The_Supermarket_Queue;

import java.util.PriorityQueue;

public class Solution {
	public static int solveSuperMarketQueue(int[] customers, int n) {
		// n : 주문을 받을 수 있는 카운터 수
		// 카운터가 모두 주문 중 이라면 순서대로 대기 하다가 주문 끝난 카운터로 감
		// 선입선출, 큐로 구현 하면 될듯
		int totalCheckOutTime = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < customers.length; i++) {
			queue.add(customers[i]);
		}
		
		for (int i = 0; i < n; i++) {
			
		}
		
		while (!queue.isEmpty()) {
			
			break;
		}

		return 0;
	}
}
