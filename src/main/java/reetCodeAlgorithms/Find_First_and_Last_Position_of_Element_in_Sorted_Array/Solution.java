package reetCodeAlgorithms.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
	
	public int[] searchRange(int[] nums, int target) {
	    if(nums.length==0) return new int[]{-1, -1};
	    int left = searchEqualorGreater(nums, target);
	    if(nums[left]!=target) return new int[]{-1, -1};
	    
	    int left_1 = searchEqualorGreater(nums, target+1);
	    int right = -1;
	    if(nums[left_1]>=target+1) right = left_1 - 1;
	    else right = left_1;
	    
	    return new int[]{left, right};
	}

	public int searchEqualorGreater(int[] nums, int target)	{
	    int lo = 0;
	    int hi = nums.length-1;
	    // hi = 5, mid = 2, lo = 3 -> mid = 3+1 = 4, hi = 4, lo = 3 -> mid = 3, hi = 3, lo = 3
	    while(lo<hi) {
	        //mid is always biased towards left
	        int mid = (hi+lo)/2;
	        if(nums[mid]<target)
	            lo = mid+1;
	        else
	            //we want to move hi to the left
	            hi = mid;
	    }
	    return lo;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] result = s.searchRange(nums, target);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
