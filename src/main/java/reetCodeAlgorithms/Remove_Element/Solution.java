package reetCodeAlgorithms.Remove_Element;

public class Solution {
	int[] nums = {0,1,2,2,3,0,4,2};
	
	public int removeElement(int[] nums, int val) {
		//val 과 같은 수 일때 : index 증가 시키지 않고 i만 증가
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(val != nums[i]) {
				nums[index++] = nums[i];
			}
		}
		
		return index;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int val = 3;
		int length = s.removeElement(s.nums, val);
		for (int i = 0; i < length; i++) {
			System.out.println(s.nums[i]);
		}

	}

}
