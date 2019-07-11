package reetCodeAlgorithms.Best_Time_to_Buy;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        
        int length = prices.length;
        // buy[i]: max profit if the first "i" days end with a "buy" day
        int[] buy = new int[length + 1];
        // buy[i]: max profit if the first "i" days end with a "sell" day
        int[] sell = new int[length + 1];
        
        buy[1] = -prices[0];
        
        for (int i = 2; i <= length; i++) {
            int price = prices[i - 1];
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
        }
        
        // sell[length] >= buy[length]
        return sell[length];
    }
    
	public static void main(String[] args) {
		maxProfit(new int[] {1,2,3,4,0,2});
	}
}
