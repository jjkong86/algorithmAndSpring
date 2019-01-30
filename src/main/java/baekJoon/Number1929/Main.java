package baekJoon.Number1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String primeCount(int min, int max) {
		if (max == 1) return "0";
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[max + 1];
		for (int i=3; i<max+1; i=i+2) {
            dp[i] = 1;
        }
		dp[2] = 1;
		for (int i = 2; i<= max; i++) {
			if (dp[i] != 0) {
				if (i >= min) sb.append(i + "\n");
				for (int j = i * 2; j <= max; j = j + i) {
					dp[j] = 0;
				}
			}
		}
		return sb.toString();
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소수(1보다 큰 자연수)의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		System.out.println(primeCount(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		br.close();
	}
}