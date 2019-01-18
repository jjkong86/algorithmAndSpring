package baekJoon.Numer1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int sumOfSquare(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        int index = 1;
        while (true) {
        	int temp = (int) Math.pow(index, 2);
        	if (temp > num) {
        		index --;
				break;
			} else {
				index++;
			}
		}
        
        for (int i = 2; i < num; i++) {
			int temp = num - (index*index);
			dp[i] = dp[temp] +1;
		}
        
        return dp[num];
    }
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		System.out.println(sumOfSquare(input));
		br.close();
	}
}

