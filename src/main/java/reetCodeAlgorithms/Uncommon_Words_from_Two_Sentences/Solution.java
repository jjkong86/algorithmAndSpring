package reetCodeAlgorithms.Uncommon_Words_from_Two_Sentences;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

class Solution {
	public String[] uncommonFromSentences(String A, String B) {
		// 두 문자열에서 중복 되지 않은 문자열은 반환
		// 한 문자열 안에서도 중복이 발생 할 수 있음
		String[] arrayA = A.split(" ");
		String[] arrayB = B.split(" ");
		
		Map<String, Integer> map = new HashMap<>();
		makeMap(map, arrayA);
		makeMap(map, arrayB);
		
		List<String> list = makeList(map);
		String[] res = new String[list.size()];
		list.toArray(res);
		System.out.println(list.toString());
		return res;
	}
	
	public void makeMap(Map<String, Integer> map, String[] array) {
		for (String str : array) {
			map.put(str, map.getOrDefault(str, 0)+1);
		}
	}
	
	public List<String> makeList(Map<String, Integer> map) {
		List<String> list = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() < 2) {
				list.add(entry.getKey());
			}
		}
		return list;
	}

	public static class TestClass {
		Solution s = new Solution();
		@Test
		public void test1() {
			assertThat(new String[] {"sweet","sour"}, is(s.uncommonFromSentences("this apple is sweet", "this apple is sour")));
		}
		
		@Test
		public void test2() {
			assertThat(new String[] {"banana"}, is(s.uncommonFromSentences("apple apple", "banana")));
		}
		
		@Test
		public void test3() {
			assertThat(new String[] {"ejt"}, is(s.uncommonFromSentences("s z z z s", "s z ejt")));
		}
	}
}
