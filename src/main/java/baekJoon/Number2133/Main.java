package baekJoon.Number2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int fillTile(int num) {
		// 3*num 크기의 벽을 2*1, 1*2 크기의 타일로 채우는 경우의 수
		// num이 홀수이면 비는칸이나 부족한 칸이 생기므로 2의 배수만 다 채울수 있다

		int[] dp = new int[num + 2];
		dp[0] = 1;
		dp[2] = 3;
		
		for (int i = 4; i <= num; i += 2) {
			dp[i] = dp[i-2]*3;
			for (int j = 4; i - j>=0; j += 2) {
				dp[i] +=dp[i-j]*2;
			}
		}
		return dp[num];
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		System.out.println(fillTile(input));
		br.close();
	}

}
