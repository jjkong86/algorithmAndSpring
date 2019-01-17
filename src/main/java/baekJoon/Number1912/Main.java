package baekJoon.Number1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static int continuousSum(int[] array) {
		// n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합
		// 연속 되어야 하고, 1개이상
		// 하나씩 더해서 1보다 크면 계속 더해감, 1보다 작으면 버리고 다시 시작함

		int len = array.length;
		int[] dp = new int[len];
		dp[0] = array[0];
		for (int i = 1; i < len; i++) {
			if (dp[i - 1] > 0 ) {
				dp[i] = dp[i - 1] + array[i];
			} else {
				dp[i] = array[i];
			}
		}
		return IntStream.of(dp).max().getAsInt();
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] array = Stream.of(split).mapToInt(i -> Integer.parseInt(i)).toArray();
		System.out.println(continuousSum(array));
		br.close();
	}

}
