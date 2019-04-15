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
		int len = A.length;
		int[] counter = new int[N];
		int max = 0;
		for (int i = 0; i < len; i++) {
			int temp = A[i] - 1;
			if (temp >= N)
				Arrays.fill(counter, max);
			else {
				int save = counter[temp] + 1;
				counter[temp] = save;
				max = save > max ? save : max;
			}
			// print(counter);
		}
		return counter;
	}

	public static void print(int[] array) {
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, array.length).forEach(i -> sj.add(String.valueOf(array[i])));
		System.out.println(sj);
	}
}
