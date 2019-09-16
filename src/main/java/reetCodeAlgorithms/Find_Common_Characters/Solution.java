package reetCodeAlgorithms.Find_Common_Characters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import org.junit.Test;

class Solution {
	public static List<String> commonChars(String[] A) {
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (String str : A) {
			for (char c : str.toCharArray()) {
				String temp = String.valueOf(c);
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			while (value >= A.length) {
				list.add(entry.getKey());
				value -= A.length;
			}
		}
		return list;
	}

	private static Comparator<Map.Entry<String, Integer>> sortByValueAndKey() {
		return (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> a.getValue() == b.getValue()
				? a.getKey().compareTo(b.getKey())
				: b.getValue().compareTo(a.getValue());
	}

	public static class TestClass {

		@Test
		public void test1() {
			assertThat(Arrays.asList(new String[] { "e", "l", "l" }),
					is(commonChars(new String[] { "bella", "label", "roller" })));
		}

		@Test
		public void test2() {
			assertThat(Arrays.asList(new String[] {}), is(commonChars(new String[] { "acabcddd", "bcbdbcbd", "baddbadb",
					"cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd" })));

		}
	}
}
