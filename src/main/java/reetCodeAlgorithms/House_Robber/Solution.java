package reetCodeAlgorithms.House_Robber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Solution {
	public static int rob(int[] nums) {
		// dp로 풀어야할듯
		if (nums.length < 1)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int[] maxSteelAmount = new int[nums.length];
		maxSteelAmount[0] = nums[0];
		maxSteelAmount[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			maxSteelAmount[i] = Math.max(maxSteelAmount[i - 1], maxSteelAmount[i - 2] + nums[i]);
		}

		return maxSteelAmount[nums.length - 1];
	}

	public static class TestClass {

		@Test
		public void test1() {
			assertThat(4, is(rob(new int[] { 1, 2, 3, 1 })));
			assertThat(1, is(rob(new int[] { 1, 1 })));
			assertThat(2, is(rob(new int[] { 2, 1 })));
		}

		@Test
		public void test2() {
			assertThat(12, is(rob(new int[] { 2, 7, 9, 3, 1 })));
		}

	}
}
