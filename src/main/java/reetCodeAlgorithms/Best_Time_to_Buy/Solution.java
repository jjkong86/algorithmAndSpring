package reetCodeAlgorithms.Best_Time_to_Buy;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        
        int length = prices.length;
        int[] buy = new int[length + 1];
        int[] sell = new int[length + 1];
        
        buy[1] = -prices[0];
        
        for (int i = 2; i <= length; i++) {
            int price = prices[i - 1];
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - price); // i-1번째에서 사는것과 i-2에 팔고 i번째에서 사는것 중 큰 값
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price); // i-1번째에서 판것(대기하는것)과 i-1번째 에서 산것을 판 값중 큰 값
            System.out.println(sell[i]);
        }
        
        // sell[length] >= buy[length]
        return sell[length];
    }
    
	public static void main(String[] args) {
		maxProfit(new int[] {1,2,3,4,0,2});
	}
}
