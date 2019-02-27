package codewars.Tribonacci_Sequence;

import java.util.Arrays;

public class Xbonacci {

	public double[] tribonacci(double[] s, int n) {
		// hackonacci me
		// s -> 초기값 3개
		// n = 4 -> s[0] + s[1] + s[2], n = 5 -> s[n-3] + s[n-2] + s[n-1]
		double[] doubleArray=Arrays.copyOf(s, n);
		if (n < 3) {
			return doubleArray;
		}
		
		tribonacciR(doubleArray, 3, n - 1);
		return doubleArray;

	}

	public void tribonacciR(double[] ds, int start, int end) {
		if (start <= end) {
			ds[start] = ds[start - 1] + ds[start - 2] + ds[start - 3];
			tribonacciR(ds, start + 1, end);
		}
	}
}
