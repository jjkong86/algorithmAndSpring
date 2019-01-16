package baekJoon.Number11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static int vitonicSequence(int[] array) {
		// 수열 S가 어떤 수 Sk를 기준으로 S[1] < S[2] < ... S[k-1] < S[k] > S[k+1] > ... S[N-1] > S[N]을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
		// 바이토닉을 만족하는 최대 길이(연속적이지 않아도 된다)
		// 수열 A의 크기 N -> 1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000
		// i-1의 수를 통해서 증가하고 있었는지, 감소하고 있었는지 판단

		int len = array.length;
		int[] dp = new int[len];
		dp[0] = 1;

		for (int i = 1; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) { // 1 2 3 2 1, i = 2, j = 1 -->> 증가하는중
					if (i - 1 >= 0 && array[i] > array[i - 1]) {
						dp[i] = dp[j] + 1;
					}
				} else if (array[i] < array[j]){ // 감소하는중
					if ((i - 1 >= 0 && array[i] < array[i - 1] || i - 1 == 0) && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		return dp[len - 1];
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] array = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		System.out.println(vitonicSequence(array));
		br.close();
	}
}
