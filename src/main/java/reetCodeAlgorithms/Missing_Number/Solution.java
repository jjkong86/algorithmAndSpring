package reetCodeAlgorithms.Missing_Number;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
    
    public static class TestClass {
    	@Test
    	public void test1() {
    		assertThat(2, is(Solution.missingNumber(new int [] {3,0,1})));
    	}
    }
}
