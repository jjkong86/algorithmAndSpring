package reetCodeAlgorithms.Search_in_Rotated_Sorted_Array;

import java.util.*;
class Solution {
    public int search(int[] nums, int target) {
        // 검색시간을 줄일 방법을 찾아야함..
        // 일단 중간값들을 찾아 들어가면서 해결
        // 
        if (nums.length < 1) return -1;
        return findTarget(nums, target, 0, nums.length-1);
    }
    
    public int findTarget(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int middle = (left + right)/2;
        int pivot = nums[middle];
        if (target > pivot) {
            int num = findTarget(nums, target, middle+1, right);
        } else if (target < pivot) {
            int num = findTarget(nums, target, left, middle -1);
        } else if (target == pivot) {
            return middle;
        }
        return -1;
    }
}
