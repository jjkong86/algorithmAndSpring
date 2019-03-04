package codewars.The_Supermarket_Queue;

import java.util.Arrays;

public class Solution {
	public static int solveSuperMarketQueue(int[] customers, int n) {
		// n : 주문을 받을 수 있는 카운터 수
		// 카운터가 모두 주문 중 이라면 순서대로 대기 하다가 주문 끝난 카운터로 감
		// 선입선출, 큐로 구현 하면 될듯
		// [10, 2, 3, 3], 2 ->> 10, 2 대기열 -> 2초후 -> 8, 0 -> 8, 3 대기열
		// -> 3초후 -> 5, 0 -> 5, 3 대기열 -> 2, 0 -> 큐 없음 -> 2, 0대기열 -> 2초후 -> 0,0
		int [] result = new int [n];
	    for (int i : customers) {
	        Arrays.sort(result);
	        result[0] += i;
	    }
	    return Arrays.stream(result).max().getAsInt();
	}
}
