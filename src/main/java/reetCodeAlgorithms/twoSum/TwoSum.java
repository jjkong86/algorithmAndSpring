package reetCodeAlgorithms.twoSum;

import java.util.Arrays;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		int[] result = new int[2];
		
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);
		
		int start = 0, end = nums2.length -1;
		
		while (start < end) {
			int sum = nums2[start] + nums2[end];
			if (sum == target) {
				result[0] = nums2[start];
				result[1] = nums2[end];
				break;
			}else if (sum > target) {
				end --;
			}else if (sum < target) {
				start ++; 
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == result[0]) {
				ret[0] = i;
				break;
			}
		}
		for (int i = nums.length -1; i >=0; i--) {
			if (nums[i] == result[1]) {
				ret[1] = i;
				break;
			}
		}
		
		return ret;
	}
}

