package baekJoon.Number1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static int primeCount(int[] array) {
		int max = IntStream.of(array).max().getAsInt();
		int[] dp = new int[max + 1];
		Arrays.fill(dp, 1);
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= max; i++) {
			if (dp[i] != 0 && i*2 < max) {
				for (int j = i * 2; j <= max; j = j + i) {
					dp[j] = 0;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count += dp[array[i]];
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소수(1보다 큰 자연수)의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] array = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		System.out.println(primeCount(array));
		br.close();
	}
}
