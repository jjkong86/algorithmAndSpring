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
		int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
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
