package reetCodeAlgorithms.Climbing_Stairs;

class Solution {
	public int climbStairs(int n) {
		// dp문제인듯
		// ... + n ->(n-1)+(n-2)
		if (n < 3)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
