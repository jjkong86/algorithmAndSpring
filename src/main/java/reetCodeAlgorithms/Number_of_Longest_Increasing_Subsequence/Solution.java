package reetCodeAlgorithms.Number_of_Longest_Increasing_Subsequence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.util.*;
class Solution {
	public int findNumberOfLIS(int[] nums) {
        // 정렬되지 않은 정수 배열이 주어지면 가장 길게 증가하는 서브 시퀀스의 수 return
        // int[][] array = new int[nums.length][2]
        // 각 index에 증가하는 서브 시퀀스의 길이와 개 수를 저장함
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        // dp[i] means the lengh of LIS ending at i
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // cnt[i] means # LIS ending at i
        int[] cnt = new int[len];
        
        int ret = 0, max = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (1 + dp[j] > dp[i]) {
                        count = cnt[j];
                        dp[i] = 1 + dp[j];
                    } else if (1 + dp[j] == dp[i]) {
                        count += cnt[j];
                    }
                }
            }
            cnt[i] = count;
            
            if (dp[i] > max) {
                ret = count;
                max = dp[i];
            } else if (dp[i] == max) {
                ret += count;
            }
        }
        return ret;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(4, is(s.findNumberOfLIS(new int[] {1,3,5,4,7,6})));
//    		assertThat(5, is(s.findNumberOfLIS(new int[] {2,2,2,2,2})));
    	}
    }
}
