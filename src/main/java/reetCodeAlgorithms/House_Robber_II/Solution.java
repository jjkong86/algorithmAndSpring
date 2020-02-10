package reetCodeAlgorithms.House_Robber_II;

class Solution {
	public int rob(int[] nums) {
		// 원형으로 처음 집과 마지막 집이 연결되어 있음

		int len = nums.length;
		int[] dpFirst = new int[len], dpSecond = new int[len];
		dpFirst[0] = nums[0];
		dpSecond[1] = nums[1];
		for (int i = 2; i < len - 1; i++) {
			dpFirst[i] = Math.max(dpFirst[i - 2] + nums[i], dpFirst[i - 1]);
			dpSecond[i + 1] = Math.max(dpSecond[i - 1] + nums[i + 1], dpSecond[i]);
		}
		return Math.max(dpFirst[len - 2], dpSecond[len - 1]);
	}
}
