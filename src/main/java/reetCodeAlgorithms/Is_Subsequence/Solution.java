package reetCodeAlgorithms.Is_Subsequence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;

		char[] chars = t.toCharArray();
		int index = 0;
		for (char c : chars) {
			if (s.charAt(index) == c) {
				index++;
				if (s.length() == index)
					return true;
			}
		}
		return s.length() == index;
	}

	public boolean isSubsequence1(String s, String t) {
		Map<Character, List<Integer>> map = new HashMap<>(26);
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.get(c) == null) {
				map.put(c, new ArrayList<>());
			}
			map.get(c).add(i);
		}
		// System.out.println(map.toString());

		int index = -1;
		for (char c : s.toCharArray()) {
			List<Integer> list = map.get(c);
			if (list == null || list.isEmpty())
				return false;

			int tempIndex = -1;
			for (Integer i : list) {
				if (i > index) {
					tempIndex = i;
					break;
				}
			}

			if (tempIndex < index) {
				return false;
			} else {
				index = tempIndex;
			}

		}
		return true;
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(s.isSubsequence1("abc", "ahbgdc"), is(true));
		}
	}

}
