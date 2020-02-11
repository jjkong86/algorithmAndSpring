package reetCodeAlgorithms.House_Robber_II;

class Solution {
	public int rob(int[] nums) {
		// 원형으로 처음 집과 마지막 집이 연결되어 있음
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}

	public int rob(int[] nums, int start, int end) {
		int prev = 0, prevPrev = 0;
		for (int i = start; i < end; i++) {
			int temp = prev;
			prev = Math.max(prevPrev + nums[i], prev);
			prevPrev = temp;
		}
		return prev;
	}
}
