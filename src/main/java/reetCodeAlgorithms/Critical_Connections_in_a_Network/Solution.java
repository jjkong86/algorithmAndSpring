package reetCodeAlgorithms.Critical_Connections_in_a_Network;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (List<Integer> list : connections) {
			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				List<Integer> temp = map.get(num);
				if (temp == null) {
					temp = new ArrayList<>();
					map.put(num, temp);
				}
				temp.add(list.get(i + (-2) * i + 1));
			}
		}
		System.out.println(map.toString());
		for (int num : map.keySet()) {
			if (map.get(num).size() < 2) {
				List<List<Integer>> res = new ArrayList<>();
				List<Integer> inner = new ArrayList<>();
				inner.add(num);
				inner.add(map.get(num).get(0));
				res.add(inner);
				return res;
			}
		}
		return new ArrayList<>();
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			Integer[][] array = new Integer[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 3, 4 }, { 4, 5 }, { 5, 3 } };
			List<List<Integer>> list = new ArrayList<>();
			for (Integer[] is : array) {
				List<Integer> temp = new ArrayList<>(Arrays.asList(is));
				list.add(temp);
			}
			
			assertThat(new ArrayList<>(Arrays.asList(new Integer[] {1, 3})), is(s.criticalConnections(6, list)));
		}

	}
}
