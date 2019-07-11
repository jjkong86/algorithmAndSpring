package reetCodeAlgorithms.Best_Time_to_Buy_and_Sell_Stock_Fee;

class Solution {
    public int maxProfit(int[] p, int fee) {
        // 수수료가 추가됨
        // 사고 팔고 횟수 제한은 없음
        
        int len = p.length;
        int[] buy = new int[len];
            buy[0] = -p[0];
        int[] sell = new int[len];
        for (int i=1; i<len; i++) {
            int price = p[i];
            buy[i] = Math.max(buy[i-1], sell[i-1] - price);
            sell[i] = Math.max(sell[i-1], buy[i-1] + price - fee);
        }
        return sell[len-1];
    }
}
