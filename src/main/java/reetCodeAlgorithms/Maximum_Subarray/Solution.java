package reetCodeAlgorithms.Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        // 서브배열에서 max
        
        if (nums.length == 1) return nums[0];
        // index 시점에서 최대값을 저장함, 최소 하나의 숫자가 포함됨
        int[] dp = new int[nums.length]; 
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1; i<nums.length; i++) {
            if (dp[i-1] + nums[i] > nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = max >= dp[i] ? max : dp[i];
        }
    
        return max;
    }
}
