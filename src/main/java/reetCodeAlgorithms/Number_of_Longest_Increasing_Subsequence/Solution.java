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
		 int N = nums.length;
	        if (N <= 1) return N;
	        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
	        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
	        Arrays.fill(counts, 1);

	        for (int j = 0; j < N; ++j) {
	            for (int i = 0; i < j; ++i) if (nums[i] < nums[j]) {
	                if (lengths[i] >= lengths[j]) {
	                    lengths[j] = lengths[i] + 1;
	                    counts[j] = counts[i];
	                } else if (lengths[i] + 1 == lengths[j]) {
	                    counts[j] += counts[i];
	                }
	            }
	        }

	        int longest = 0, ans = 0;
	        for (int length: lengths) {
	            longest = Math.max(longest, length);
	        }
	        for (int i = 0; i < N; ++i) {
	            if (lengths[i] == longest) {
	                ans += counts[i];
	            }
	        }
	        return ans;
    }
    
    public int calLength(int[] nums, int[] array, int i, int prev) {
        if (prev < 0) return 1;
        if (nums[i] <= nums[prev]) {
            return calLength(nums, array, i, prev-1);
        }
        return array[prev]+1;
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
