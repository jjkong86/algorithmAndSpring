package codewars.Maximum_subarray_sum;

import java.util.stream.IntStream;

public class Max {
	public static int sequence(int[] arr) {
		// 배열에서 연속적인 수의 합이 가장 큰 수를 리턴
		// 각 배열자리에서 최대값을 채워 나가면??
		if (arr.length < 1)
			return 0;
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
		}
		int max = IntStream.of(arr).max().getAsInt();
		return max < 0 ? 0 : max;
	}
}
