package baekJoon.Number2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int stairClimb(int[] array, int len) {
		// 계단은 1단계, 2단계 오를 수 있다
		// 연속된 세 개의 계단은 안됨 -> 2개까지만, 단 시작점 포함 x
		// 마지막 도착 계단 무조건 밟아야함
		// oxo, xoo, oox 3가지 경우의 수인듯? --> oox는 안됨 -> ex 10 10 1 1 10 계단을 한번에 새개 올라가게됨....
		int[] dp = new int[(len < 2 ? 2 : len) + 1];
		dp[0] = 0;
		dp[1] = array[0];
		dp[2] = array[0] + array[1];
		for (int i = 3; i <= len; i++) {
			int case1 = dp[i - 2] + array[i - 1];
			int case2 = dp[i - 3] + array[i - 2] + array[i - 1];
			dp[i] = Math.max(case1, case2);
		}
		return dp[len];
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] array = new int[len < 2 ? 2 : len];
		for (int i = 0; i < len; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(stairClimb(array, len));
		br.close();
	}
}
