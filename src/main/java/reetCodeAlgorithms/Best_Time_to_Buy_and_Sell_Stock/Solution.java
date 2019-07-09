package reetCodeAlgorithms.Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
	public int maxProfit(int[] prices) {
        // 두 수의 차가 가장 큰 수
        // 작은 수가 먼저 나와야함
        // O(nlongn)방식으로 먼저 하고 최적화
        int len = prices.length;
        int maxPrice = 0, tempPrice = 0;
        
        for (int i=1; i<len; i++) {
            tempPrice = Math.max(0, tempPrice += prices[i] - prices[i-1]);
            maxPrice = Math.max(maxPrice, tempPrice);
        }
        return maxPrice;
	}
}
