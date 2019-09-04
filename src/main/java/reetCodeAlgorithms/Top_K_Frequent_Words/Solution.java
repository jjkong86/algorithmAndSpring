package reetCodeAlgorithms.Top_K_Frequent_Words;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	boolean isDuple = false;
	public List<String> topKFrequent(String[] words, int k) {
		if (words.length < 1) return new ArrayList<>(); 
		
		Map<String, Integer> map = makeMap(words, k);
		List<String> list = new ArrayList<>();
		map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEachOrdered(x -> list.add(x.getKey()));
		if (isDuple) {
			Collections.reverse(list);
			System.out.println(list.toString());
			return list;
		}
		System.out.println(list.toString());
		return list;
	}

	private Map<String, Integer> makeMap(String[] words, int k) {
		Map<String, Integer> duple = new HashMap<>();
		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for (String key : words) {
			map.put(key, map.getOrDefault(key, 0)+1);
			if (map.get(key) == k) {
				count ++;
				duple.put(key, k);
			}
		}
		if (count > 1) {
			isDuple = true;
			return duple;
		}
		return map;
	}
	
	public static class TestClass {
		@Test
		public void test1() {
			Solution s = new Solution();
			assertThat(Arrays.asList(new String[] {"i", "love"}), 
					is(s.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2)));
		}
		
		@Test
		public void test2() {
			Solution s = new Solution();
			assertThat(Arrays.asList(new String[] {"the", "is", "sunny", "day"}), 
					is(s.topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)));
		}
		
		@Test
		public void test3() {
			Solution s = new Solution();
			assertThat(Arrays.asList(new String[] {"i"}), 
					is(s.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 1)));
		}
	}
}
