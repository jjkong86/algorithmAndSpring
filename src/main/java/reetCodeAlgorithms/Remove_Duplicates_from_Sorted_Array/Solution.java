package reetCodeAlgorithms.Remove_Duplicates_from_Sorted_Array;

public class Solution {
	int[] nums = {0,0,1,1,1,2,2,3,3,4};
	
	public int removeDuplicates(int[] nums) {
		int j=0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int length = s.removeDuplicates(s.nums);
		for (int i = 0; i < length; i++) {
			System.out.println(s.nums[i]);
		}
	}
}
