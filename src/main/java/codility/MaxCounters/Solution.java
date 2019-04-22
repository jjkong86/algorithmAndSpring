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
		
		for (int i = 0; i < len; i++) {
			int temp = A[i] - 1;
			if (temp >= 0 && temp < N) {
				int save = counter[temp];
				counter[temp] = Math.max(save, addMax) + 1;
				if (++save > max) {
					max = save;
					maxChangeFlag = true;
				}
			} else if (temp == N && maxChangeFlag) {
				addMax = max;
				maxChangeFlag = false;
			}
//			print(counter);
		}
		
		for (int i=0; i<counter.length; i++) {
			    counter[i] = Math.max(counter[i], addMax);
		}
//		print(counter);
		return counter;
	}

	public static void print(int[] array) {
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, array.length).forEach(i -> sj.add(String.valueOf(array[i])));
		System.out.println(sj);
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
		
		System.out.println(Arrays.toString(s.solution2(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
		System.out.println(Arrays.toString(s.solution2(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
		System.out.println(Arrays.toString(s.solution2(1, new int[] { 2, 1, 1, 2, 1 })));
	}
}
