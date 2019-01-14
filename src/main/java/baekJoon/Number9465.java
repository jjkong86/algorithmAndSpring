package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number9465 {

	public static int maxScore(int[][] arrays) {
		//arrays[0][n]과 arrays[1][n]이 초기 경우의 수
		int len = arrays[0].length;
		
		int[][] dp = new int[2][len+1];
		dp[0][0] = dp[1][0] = 0;
		dp[0][1] = arrays[0][0];
		dp[1][1] = arrays[1][0];
		
		for (int i = 2; i <= len; i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+arrays[0][i-1];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+arrays[1][i-1];
		}
		
		return Math.max(dp[1][len], dp[0][len]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < len; i++) {
			int cardNum = Integer.parseInt(br.readLine());
			int[][] scoreBundle = new int[2][cardNum];
			for (int j = 0; j < scoreBundle.length; j++) {
				String[] split = br.readLine().split(" ");
				for (int k = 0; k < split.length; k++) {
					scoreBundle[j][k] = Integer.parseInt(split[k]);
				}
			}
			sj.add(String.valueOf(maxScore(scoreBundle)));
		}
		System.out.println(sj);
		br.close();
	}
}
