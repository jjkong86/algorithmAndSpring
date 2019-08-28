package reetCodeAlgorithms.Min_Cost_Climbing_Stairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1,2단계 계단을 오를 수 있음, 최소비용을 찾아야함
        // 시작점의 index는 0, 1 선택 가능
        // Mindp[n] = Math.min(dp[n-2] + cost[n], dp[n-1] + cost[n])
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<len; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        
        return Math.min(dp[len-2], dp[len-1]);
    }
}