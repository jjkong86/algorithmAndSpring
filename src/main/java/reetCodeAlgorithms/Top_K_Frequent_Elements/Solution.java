package reetCodeAlgorithms.Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(k).forEachOrdered(x -> res.add(x.getKey()));
        return res;
    }
}
