package reetCodeAlgorithms.Median_of_Two_Sorted_Arrays;

class Solution3 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		int[] array = new int[len / 2 + 1];
		int nums1Idx = 0, nums2Idx = 0;
		for (int i = 0; i <= len / 2; i++) {
			if (nums1Idx >= nums1.length) {
				array[i] = nums2[nums2Idx++];
				continue;
			} else if (nums2Idx >= nums2.length) {
				array[i] = nums1[nums1Idx++];
				continue;
			}

			if (nums1[nums1Idx] < nums2[nums2Idx]) {
				array[i] = nums1[nums1Idx++];
			} else {
				array[i] = nums2[nums2Idx++];
			}
		}
		return len % 2 == 0 ? (double) (array[len / 2] + array[len / 2 - 1]) / 2 : array[len / 2];
	}
}
