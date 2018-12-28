package reetCodeAlgorithms.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<Object> ret = new ArrayList<>();
//		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Map<String, Integer> numsMap = new HashMap<>();
		for (Integer integer : nums) {
			String numStr = String.valueOf(integer);
			numsMap.put(numStr, integer);
		}

		for (int i = 0; i < nums.length; i++) {
			int firstNum = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				int SeNum = nums[j];
				String key = String.valueOf((firstNum + SeNum)*(-1));
				System.out.println(key);
				if (key == null) {
					System.out.println("key null");
					continue;
				}
				int sol = numsMap.get(key);
				if (firstNum + SeNum == sol) {
					List<Integer> tempRet = new ArrayList<>();
					tempRet.add(firstNum);
					tempRet.add(SeNum);
					tempRet.add((firstNum + SeNum)*(-1));
					ret.add(tempRet);
				}

			}
		}
		System.out.println(ret);
		return null;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		s.threeSum(nums);
		Map<String, Integer> numsMap = new HashMap<>();
		for (Integer integer : nums) {
			String numStr = String.valueOf(integer);
			numsMap.put(numStr, integer);
		}
//		System.out.println(numsMap.get("5"));

	}

}
