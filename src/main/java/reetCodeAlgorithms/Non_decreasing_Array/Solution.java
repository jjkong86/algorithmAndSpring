package reetCodeAlgorithms.Non_decreasing_Array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
	public static boolean checkPossibility(int[] nums) {
		int cnt = 0;
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return cnt<=1;
    }
    
    public static class TestClass {
    	
    	@Test
    	public void test1() {
    		assertThat(true, is(checkPossibility(new int[] {4,2,3})));
    	}
    }
    
}
