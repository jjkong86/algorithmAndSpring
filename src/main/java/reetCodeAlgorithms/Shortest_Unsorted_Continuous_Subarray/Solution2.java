package reetCodeAlgorithms.Shortest_Unsorted_Continuous_Subarray;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Solution2 {

	public int findUnsortedSubarray(int[] nums) {
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int start = 0, end = 0;
		for (int i=0; i<nums.length; i++) {
			max = Math.max(nums[i], max);
			if (nums[i] < max) {
				end = i;
			}
		}
		
		for (int i = nums.length-1; i>=0; i--) {
			min = Math.min(nums[i], min);
			if (nums[i] > min) {
				start = i;
			}
		}
		if (start + end == 0) return 0;
		return end-start+1;
	}
	
	public static class TestClass {
    	Solution2 s = new Solution2();
    	@Test
    	public void test1() {
    		assertThat(5, is(s.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})));
    		assertThat(0, is(s.findUnsortedSubarray(new int[] {1,2,3,4})));
    	}
    }
}
