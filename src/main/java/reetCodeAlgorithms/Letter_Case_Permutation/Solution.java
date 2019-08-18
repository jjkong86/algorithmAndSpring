package reetCodeAlgorithms.Letter_Case_Permutation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

class Solution {
	public List<String> letterCasePermutation(String S) {
		// 재귀적으로 이용하고, 각 대소문자 여부 판별할 index를 갖고 다녀야할듯
		// 'a' ~ 'z' = 97 ~ 122
		// 'A' ~ 'Z' = 65 ~ 90
		Set<String> set = permutation(S, new HashSet<>(), 0);
		List<String> list = new ArrayList<>(set);
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				for (int i = 0; i < s1.length(); i++) {
//					int res = Integer.compare((int)s1.charAt(i), (int)s2.charAt(i));
//					if (res != 0) {
//						return res*(-1);
//					}
//				}
//				return 0;
//			}
//		});
		return list;
	}

	public Set<String> permutation(String str, Set<String> set, int index) {
		if (index >= str.length()) {
			if (!"".equals(str)) set.add(str);
			System.out.println(set);
			return set;
		}

		String res = "";
		int i = 0;
		for (i = index; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!"".equals(res = isCharater(c, str, i))) break;
		}
		
		permutation(str, set, i+1);
		permutation(res, set, i+1);

		return set;
	}

	public String isCharater(char c, String str, int index) {
		String res = "";
		if (c >= 65 && c <= 90) {
			res = makeLower(str, index);
		} else if (c >= 97 && c <= 122) {
			res = makeUpper(str, index);
		}
		return res;
	}

	public String makeUpper(String str, int index) {
		StringBuilder sb = new StringBuilder();
		return sb.append(str.substring(0, index)).append(Character.toUpperCase(str.charAt(index)))
				.append(str.substring(index + 1)).toString();
	}

	public String makeLower(String str, int index) {
		StringBuilder sb = new StringBuilder();
		return sb.append(str.substring(0, index)).append(Character.toLowerCase(str.charAt(index)))
				.append(str.substring(index + 1)).toString();
	}
	
	public static class TesetClass {
		Solution s = new Solution();
		@Test
		public void test1() {
			assertThat(Arrays.asList(new String[] {"a1b2", "a1B2", "A1b2", "A1B2"}), is(s.letterCasePermutation("a1b2")));
		}
		
		@Test
		public void test2() {
			assertThat(Arrays.asList(new String[] {"3z4", "3Z4"}), is(s.letterCasePermutation("3z4")));
		}
		
		@Test
		public void test3() {
			assertThat(Arrays.asList(new String[] {"12345"}), is(s.letterCasePermutation("12345")));
		}
	}
}
