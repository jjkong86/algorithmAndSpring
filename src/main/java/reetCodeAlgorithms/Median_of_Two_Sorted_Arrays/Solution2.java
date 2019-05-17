package reetCodeAlgorithms.Median_of_Two_Sorted_Arrays;

class Solution2 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 정렬된 두 배열의 중앙값을 찾는 문제

		int mergeLen = nums1.length + nums2.length;
		int[] array = new int[mergeLen];
		int index1 = 0, index2 = 0;

		for (int i = 0; i < mergeLen; i++) {
			if (nums1.length <= index1) {
				array[i] = nums2[index2++];
			} else if (nums2.length <= index2) {
				array[i] = nums1[index1++];
			} else if (nums1[index1] > nums2[index2]) {
				array[i] = nums2[index2++];
			} else {
				array[i] = nums1[index1++];
			}
			if (mergeLen / 2 <= i) break;
		}
		// System.out.println(Arrays.toString(array));
		return mergeLen % 2 == 0 ? (double) (array[mergeLen / 2] + array[mergeLen / 2 - 1]) / 2 : array[mergeLen / 2];
	}
}
