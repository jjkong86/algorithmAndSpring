package reetCodeAlgorithms.Range_Sum_Query_Immutable;

import org.junit.Test;

class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }

    public static class TestClass {
        @Test
        public void test1() {
            NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
            System.out.println(numArray.sumRange(0, 2));
            System.out.println(numArray.sumRange(2, 5));
            System.out.println(numArray.sumRange(0, 5));
        }
    }
}
