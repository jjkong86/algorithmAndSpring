package codility.MissingInteger;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

import java.util.*;

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		// 주어진 배열 요소 중 존재 하지 않은 최소값(0보다 큼)
		// 쉬운방법 부터 : 정렬 후 비교해봄
		if (A.length < 1)
			return 1;

		return minFind(A);
	}

	public int minFind(int[] A) {
		Arrays.sort(A);
		int notExstNum = 1;
		int len = A.length;
		boolean changeFlag = false;
		for (int i = 1; i < len; i++) {
			if (A[i] - A[i - 1] == 1) {
				continue;
			} else if (A[i - 1] > 0 && A[i] - A[i - 1] > 1) {
				notExstNum = A[i - 1] + 1;
				changeFlag = true;
				break;
			}
		}
		return changeFlag ? notExstNum : A[len - 1] + 1 > 0 ? A[len - 1] + 1 : 1;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] test1 = new int[100];
//		for (int i = 0; i < test1.length; i++) {
//			if (i == 50) continue;
//			test1[i] = i+100;
//		}
		System.out.println(s.solution(new int[] {-1, 2}));
//		System.out.println(s.solution(test1));
	}
}
