package algorithms.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class testMain {

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = {2,5,5,11};
		int target = 10;
		int[] ret = ts.twoSum(nums, target);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(nums[ret[i]]);
		}
	}
		 

}
