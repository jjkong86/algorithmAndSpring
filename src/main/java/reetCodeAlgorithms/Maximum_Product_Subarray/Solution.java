package reetCodeAlgorithms.Maximum_Product_Subarray;

import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        // 연속된 하위 배열에서 곱이 가장 큰 수
        // -도 있기 때문에 -값도 가지고 다녀야할듯??
        // -3, -2, -1, 0, 1, 2
        if (nums.length == 0) return 0;
        
        int len = nums.length;
        int[] maxArray = new int[len];
        int[] minArray = new int[len];
        maxArray[0] = nums[0];
        minArray[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<len; i++) {
            if (nums[i-0] <= nums[i]) {
                maxArray[i] = Math.max(maxArray[i-1]*nums[i], Math.max(nums[i], minArray[i-1]*nums[i]));
                minArray[i] = Math.min(minArray[i-1]*nums[i], Math.min(nums[i], maxArray[i-1]*nums[i]));
            } else {
                maxArray[i] = nums[i];
                minArray[i] = nums[i];
            }
            //System.out.println(Arrays.toString(maxArray));
            //System.out.println(Arrays.toString(minArray));
            if (maxArray[i] > max) max = maxArray[i];
        }
        return max;
    }
}
