package reetCodeAlgorithms.Search_in_Rotated_Sorted_Array;

class Solution {
    public int search(int[] nums, int target) {
        // 검색시간을 줄일 방법을 찾아야함..
        // 일단 중간값들을 찾아 들어가면서 해결
        // nums[0] > nums[nums.length-1] 보다 항상 큼
        
        if (nums.length < 1) return -1;
        
        int index = 0;
        
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > nums[i+1]) {
                index = i+1;
                break;
            }
        }
        return findTarget(nums, target, index, nums.length-1);
    }
    
    public int findTarget(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int midIndex = (left+right)/2;
        int mid = nums[midIndex];
        
        if (mid == target) {
            return midIndex;
        } else if (mid > target) {
            return findTarget(nums, target, left, midIndex-1);
        } else {
            return findTarget(nums, target, midIndex+1, right);
		}
	}
}
