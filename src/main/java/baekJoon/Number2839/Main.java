package baekJoon.Number2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int dpCount(int[] dp, int num, int ret) {
		if (num < 3) {
			return 0;
		}
		if (num % 5 == 0) {
			return dp[num] + ret;
		} else if (num % 3 == 0){
			return dp[num] + ret;
		} else {
			ret = dpCount(dp, num-5, ret +1);
		}
		return ret;
	}
	
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] dp = new int[input+1];
		int number = 2; 
		while (number < input) {
			number++;
			if (number % 5 == 0) {
				dp[number] = dp[number - 5] +1;
			} else if (number % 3 == 0) {
				dp[number] = dp[number - 3] +1;
			} else {
				int ret = dpCount(dp, number, 0);
				if (ret != 0) {
					dp[number] = ret;
				} else {
					dp[number] = -1;
				}
			}
		}
		System.out.println(dp[number]);
		br.close();
	}
}
