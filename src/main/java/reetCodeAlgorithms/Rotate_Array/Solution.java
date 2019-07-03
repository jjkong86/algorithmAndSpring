package reetCodeAlgorithms.Rotate_Array;

import java.util.*;
class Solution {
    public void rotate(int[] nums, int k) {
        // k만큼 오른쪽으로 회전
        // k%nums.length 만큼 숫자를 교환
        if (k == 0 || k%nums.length == 0) return;
        int len = nums.length;
        k = k%len;
        for (int i=0; i<len/2; i++) {
            System.out.println(i+"::"+k);
            swap(nums, i, len-k+i);
        }
        if (len/2 % 2 != 0) {
            swap(nums, len/2, len-1);
        }
    }
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
