package codility.MaxCounters;

import java.util.*;
import java.util.stream.*;
class Solution {
	public int[] solution(int N, int[] A) {
		// write your code in Java SE 8
		// 1<= A[K] <= N -> X + 1
		// A[K] == N+1 -> 모든 counter max로 채움
		if (N == 0) return new int[] {};
		int len = A.length;
		int[] counter = new int[N];
		int max = 0;
		int addMax = 0;
		boolean maxChangeFlag = false;
		
//		System.out.println("=================================");
//		System.out.println("start : "+Arrays.toString(A));
		for (int k = 0; k < len; k++) {
			if (A[k] >= 1 && A[k] <= N) {
				int saveInt = A[k] - 1;
				counter[saveInt] = Math.max(counter[saveInt], addMax) + 1;
				max = Math.max(max, counter[saveInt]);
			} else if (A[k] == N + 1) {
				addMax = max;
			}
		}
		
		for (int i=0; i<counter.length; i++) {
		    counter[i] = Math.max(counter[i], addMax);
		}
//		System.out.println(Arrays.toString(counter));
//		System.out.println("=================================");
		return counter;
	}
	
	public int[] solution2(int N, int[] A) {
		// write your code in Java SE 8
		int max = 0;
		int lastMax = 0;
		int[] counters = new int[N];

		for (int k = 0; k < A.length; k++) {
			if (A[k] >= 1 && A[k] <= N) {
				counters[A[k] - 1] = Math.max(counters[A[k] - 1], lastMax);
				counters[A[k] - 1] += 1;
				max = Math.max(max, counters[A[k] - 1]);
			} else if (A[k] == N + 1) {
				lastMax = max;
			}
		}
		
		for(int i = 0 ; i < counters.length; i++) {
			counters[i] = Math.max(counters[i], lastMax);
		}

		return counters;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
		System.out.println(Arrays.toString(s.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
		System.out.println(Arrays.toString(s.solution(1, new int[] { 2, 1, 1, 2, 1 })));
		System.out.println(Arrays.toString(s.solution(1, new int[] { 5, 5, 5, 2, 5 })));
		System.out.println(Arrays.toString(s.solution(4, new int[] { 1, 2, 1, 1, 1 })));
		
//		System.out.println(Arrays.toString(s.solution2(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
//		System.out.println(Arrays.toString(s.solution2(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
//		System.out.println(Arrays.toString(s.solution2(1, new int[] { 2, 1, 1, 2, 1 })));
	}
}
