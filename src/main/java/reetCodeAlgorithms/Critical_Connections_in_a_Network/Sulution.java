package reetCodeAlgorithms.Critical_Connections_in_a_Network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
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
}
