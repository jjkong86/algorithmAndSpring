package reetCodeAlgorithms.Move_Zeroes;

class Solution {
	public void moveZeroes(int[] nums) {
		if (nums.length < 1)
			return;
		int zeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, zeroIndex++);
			}
		}
	}

	public void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
