package baekJoon.Number2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int maxAmount(int[] amount) {
		//3잔 이상 연속은 안됨
		//초기 index 부터 최대값을 채워 나가는 방식으로
		//하지만 n-3 인덱스 까지 고려 하여 최대값을 구해야함
		//oox, oxo, xoo -> x가 나오는 시점의 dp[i-1]을 더해주고 고려한다 
		int len = amount.length;
		int[] dp = new int[len];
        if (len >= 1) {
            dp[0] = amount[0];
        }
        if (len >= 2) {
            dp[1] = amount[0] + amount[1];
        }
        if (len >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + amount[2], amount[1] + amount[2]));
        }
        
        for (int i = 3; i < len; i++) {
        	int case1 = dp[i - 3] + amount[i - 1] + amount[i]; // ..dp[i-3] / x / o / o /
        	int case2 = dp[i - 2] + amount[i]; // ..dp[i-2] / x / o /
        	int case3 = dp[i - 1]; // o / o / <- dp[i-1]
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }
        return dp[len - 1];
        
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] amount = new int[len+1];
		amount[0] = 0;
		for (int i = 1; i <= len; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(maxAmount(amount));
		br.close();
	}
}
