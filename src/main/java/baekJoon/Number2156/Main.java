package baekJoon.Number2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int maxAmount(int[] amount) {
		//3잔 이상 연속은 안됨
		//초기값은 index = 0, 1 일때 시작할 수 있음..
		int len = amount.length;
		int[] dp = new int[len+1]; // dp[0][n], dp[1][n]
		for (int i = 2; i < amount.length; i++) {
			
		}
		return dp[len-1];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] amount = new int[len];
		for (int i = 0; i < len; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(maxAmount(amount));
		br.close();
		
	}

}
