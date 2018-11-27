package reetCodeAlgorithms.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<Object> ret = new ArrayList<>();
		int sum = 0;
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		for (int i = 0; i < nums.length; i++) {
			int firstNum = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				int SeNum = nums[j];
				if (firstNum + SeNum == list.get((firstNum + SeNum)*(-1))) {
					List<Integer> tempRet = new ArrayList<>();
					tempRet.add(firstNum);
					tempRet.add(SeNum);
					tempRet.add((firstNum + SeNum)*(-1));
					ret.add(tempRet);
				}
				
			}
		}
		System.out.println(sum);
		return null;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		s.threeSum(nums);
	}

}
