package baekJoon.Numer1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int sumOfSquare(int num) {
    	//제곱수의 합
    	//제곱수 항의 최소 개수
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= num; i++) {
        	dp[i] = dp[i-1]+1;
			int square = findSquare(i);
			for (int j = 2; j <= square; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
        return dp[num];
    }
    
    public static int findSquare(int num) {
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
    	return index;
    }
    
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		System.out.println(sumOfSquare(input));
		br.close();
	}
}
