package reetCodeAlgorithms.Number_of_Longest_Increasing_Subsequence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
	public int findNumberOfLIS(int[] nums) {
        // 정렬되지 않은 정수 배열이 주어지면 가장 길게 증가하는 서브 시퀀스의 수 return
        // int[][] array = new int[nums.length][2]
        // 각 index에 증가하는 서브 시퀀스의 길이와 개 수를 저장함
        if (nums.length < 1) return 0;
        
        int[] array = new int[nums.length];
        array[0] = 1;
        int max = 1;
        int maxNum = 0;
        for (int i=1; i<nums.length; i++) {
            array[i] = calLength(nums, array, i, i-1, max);
            if (max < array[i]) {
                max = array[i];
                maxNum = nums[i];
            }
        }
        
        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == max-1 && nums[i] < maxNum) {
                count++;
            }
        }
        
        return count;
    }
    
    public int calLength(int[] nums, int[] array, int i, int prev, int max) {
        if (prev < 0) return 1;
        if (max > array[prev] || nums[i] < nums[prev]) {
            return calLength(nums, array, i, prev-1, max);
        }
        return array[prev]+1;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(2, is(s.findNumberOfLIS(new int[] {1,3,5,4,7})));
    	}
    }
    
}
