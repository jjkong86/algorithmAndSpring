package codility.MaxCounters;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");
import java.util.*;
import java.util.stream.*;

class Solution {
	public int[] solution(int N, int[] A) {
		// write your code in Java SE 8
		// 1<= A[K] <= N -> X + 1
		// A[K] > N -> 모든 counter max로 채움
		if (N == 0) return new int[] {};
		int len = A.length;
		int[] counter = new int[N];
		int max = 0;
		boolean maxChangeFlag = false;
		for (int i = 0; i < len; i++) {
			int temp = A[i] - 1;
			if (temp >= N ) {
				if (maxChangeFlag) {
					Arrays.fill(counter, max);
					maxChangeFlag = false;
				}
			} else {
				int save = counter[temp] + 1;
				counter[temp] = save;
				if (save > max) {
					max = save;
					maxChangeFlag = true;
				}
			}
			print(counter);
		}
		return counter;
	}

	public static void print(int[] array) {
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, array.length).forEach(i -> sj.add(String.valueOf(array[i])));
		System.out.println(sj);
	}
}
