package reetCodeAlgorithms.Median_of_Two_Sorted_Arrays;

import java.util.Arrays;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1L = nums1.length;
	  	int nums2L = nums2.length;
	  	int[] arrSum = new int[nums1L+nums2L];
	  	int count = 0;
	  	double ret = 0;
		for (int i = 0; i < nums1L; i++) {
			arrSum[i] = nums1[i];
			count++;
		}
		for (int i = 0; i < nums2L; i++) {
			arrSum[count++] = nums2[i];
		}
		Arrays.sort(arrSum);
		
		int retLength = arrSum.length;
		ret = retLength%2 == 0 ? (double)(arrSum[retLength/2] + arrSum[retLength/2 -1])/2 : 
			arrSum[retLength/2];
		
		return ret;
	}
	
	public static void main(String[] args) {
		Solution so = new Solution();
		int[] nums1 = {1, 3,3,3,3,3};
		int[] nums2 = {2};
		double result = so.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
		
	}

}
