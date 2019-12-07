package reetCodeAlgorithms.Combination_Sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] c, int target) {
		// 주어진 숫자(target)의 합을 구하는 문제
		findSum(c, target, 0, new ArrayList<>());
		return list;
	}

	public void findSum(int[] c, int target, int sum, List<Integer> innerList) {
		if (sum >= target) {
			if (sum == target) {
				Collections.sort(innerList);
				list.add(innerList);
			}
			return;
		}

		for (int num : c) {
			List<Integer> tempList = new ArrayList<>();
			tempList.addAll(innerList);
			tempList.add(num);
			findSum(c, target, sum + num, tempList);
		}
	}
}
