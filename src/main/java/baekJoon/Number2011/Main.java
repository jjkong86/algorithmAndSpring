package baekJoon.Number2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int crypticCode(String input) {
		//dp[i] = dp[i-1] + dp[i-2]
		if (input.equals("0")) {
			return 0;
		}
		char[] charArray = input.toCharArray();
		int len = charArray.length;
		int mod = 1000000;
		int[] dp = new int[len + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= len; i++) {
			if (charArray[i-1] > '0') {
				dp[i] = dp[i - 1];
			}
			
			int sumNumber = Integer.parseInt(Character.toString(charArray[i-2]) + Character.toString(charArray[i-1]));
			if (sumNumber >= 10 && sumNumber <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % mod;
			}
		}
		return dp[input.length()];
	}
	
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		System.out.println(crypticCode(input));
		br.close();
	}
}
