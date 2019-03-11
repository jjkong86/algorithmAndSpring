package codewars.Equal_Sides_Of_An_Array;

import java.util.stream.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.*;

public class Kata {
	public static int findEvenIndex(int[] arr) {
		// 배열 index를 기준으로 좌 우 합이 같으면 index를 리턴, 없으면 -1
		// 0 < arr < 1000
		// index가 2개 이상이면 index가 작은것을 리턴
		// 일단 o(n2) 복잡도로 풀고 생각
		print(arr);
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			LongAdder leftSum = new LongAdder();
			LongAdder rightSum = new LongAdder();
			IntStream.range(0, i).forEach(leftSum::add);
			IntStream.range(i, len).forEach(rightSum::add);

			if (leftSum == rightSum)
				return i;
		}
		return -1;
	}

	public static void print(int[] arr) {
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, 5).forEach(i -> sj.add(String.valueOf(arr[i])));
		System.out.println(sj);
	}
}
