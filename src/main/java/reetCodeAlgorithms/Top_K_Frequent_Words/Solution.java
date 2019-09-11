package reetCodeAlgorithms.Top_K_Frequent_Words;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		if (words.length < 1)
			return Collections.emptyList();

		Map<String, Integer> map = makeMap(words, k);
		List<String> list = new LinkedList<>();
		map.entrySet().stream().sorted(sortByValueAndKey()).limit(k).forEachOrdered(x -> list.add(x.getKey()));
		System.out.println(list.toString());
		return list;
	}

	private Map<String, Integer> makeMap(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String key : words) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		return map;
	}

	private Comparator<Map.Entry<String, Integer>> sortByValueAndKey() {
		return (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> a.getValue() == b.getValue()
				? a.getKey().compareTo(b.getKey())
				: b.getValue().compareTo(a.getValue());
	}

	public static class TestClass {
		@Test
		public void test1() {
			Solution s = new Solution();
			assertThat(Arrays.asList(new String[] { "i", "love" }),
					is(s.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2)));
		}

		@Test
		public void test2() {
			Solution s = new Solution();
			assertThat(Arrays.asList(new String[] { "the", "is", "sunny", "day" }),
					is(s.topKFrequent(
							new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" },
							4)));
		}
	}
}
