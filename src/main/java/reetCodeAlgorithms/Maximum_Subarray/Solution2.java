package reetCodeAlgorithms.Maximum_Subarray;

import java.util.Arrays;

class Solution2 {
	public static int maxSubArray(int[] nums) {
		// dp로 문제 해결
		int len = nums.length;
		int[] subArray = new int[len];
		subArray[0] = nums[0];
		int max = subArray[0];
		for (int i = 1; i < len; i++) {
			if (subArray[i-1] + nums[i] < 0) {
				subArray[i] = nums[i];
			} else {
				subArray[i] = Math.max(nums[i], subArray[i-1] + nums[i]);
			}
			System.out.println(Arrays.toString(subArray));
			if (subArray[i] > max) max = subArray[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
