package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11052 {
	
	public static int maxprice(int cardNum, int[] cardPack) {
        // 1부터 최대값을 n까지 채워 나가면 될듯?
        int[] dp = new int[cardNum+1];
        dp[0] = 0;
        dp[1] = cardPack[1];
        for (int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + cardPack[1];
            for (int j = 2; j <= i; j++) {
        		dp[i] = Math.max(dp[i], dp[i-j]+cardPack[j]);
			}
        }
        return dp[cardNum];
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardNum = Integer.parseInt(br.readLine());
        String[] cardPack = br.readLine().split(" ");
        int[] cardPackArray = new int[cardNum+1];
        for (int i=1; i<=cardPack.length; i++) {
        	cardPackArray[i] = Integer.parseInt(cardPack[i-1]);
        }
        
        System.out.println(maxprice(cardNum, cardPackArray));
    }
}
