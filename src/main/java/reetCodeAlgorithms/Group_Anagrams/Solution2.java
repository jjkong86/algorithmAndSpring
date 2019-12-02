package reetCodeAlgorithms.Group_Anagrams;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution2 {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new LinkedHashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sort = String.valueOf(chars);
			if (!map.containsKey(sort)) {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(sort, list);
			} else {
				map.get(sort).add(str);
			}
		}

		List<List<String>> list = new LinkedList<>();
		for (Map.Entry<String, List<String>> tempList : map.entrySet()) {
			List<String> temp = tempList.getValue();
			Collections.sort(temp);
			list.add(0, temp);
		}
		return list;
	}

	public static class TestClass {

		@Test
		public void test1() {
			Solution2 s = new Solution2();
			assertThat("", is(s.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" })));
		}
	}
}
