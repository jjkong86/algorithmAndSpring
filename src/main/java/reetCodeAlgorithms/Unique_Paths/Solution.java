package reetCodeAlgorithms.Unique_Paths;


class Solution {
    public int uniquePaths(int m, int n) {
        // 이동 가능한 경로는 아래와 오른쪽
        // dp로 풀어야할듯
        // n-1에서 n으로 갈 수 있는 경우의 수를 찾아야함
        // (m, n) = (m-1, n) + (m, n-1)
        
        if (m == 1 || n == 1) return 1;
        
        int[][] dp = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) {
                    dp[0][0] = 1;
                    continue;
                }
                dp[i][j] = (i-1 < 0 ? 0 : dp[i-1][j]) + (j - 1 < 0 ? 0 : dp[i][j-1]);
                //System.out.println("dp["+i+"]["+j+"] = "+dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
