package reetCodeAlgorithms.Uncommon_Words_from_Two_Sentences;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

class Solution {
	public String[] uncommonFromSentences(String A, String B) {
		// 두 문자열에서 중복 되지 않은 문자열은 반환
		// 한 문자열 안에서도 중복이 발생 할 수 있음
		Set<String> setA = makeSet(A.split(" "));
		Set<String> setB = makeSet(B.split(" "));
		List<String> res = new ArrayList<>();

		for (String str : setA) {
			if (!setB.contains(str)) {
				res.add(str);
			}
		}
		
		for (String str : setB) {
			if (!setA.contains(str)) {
				res.add(str);
			}
		}

		String[] result = new String[res.size()];
		res.toArray(result);
		System.out.println(Arrays.toString(result));
		return result;
	}

	public Set<String> makeSet(String[] array) {
		Set<String> set = new HashSet<>();
		Set<String> duple = new HashSet<>();
		for (String str : array) {
			if (set.contains(str)) {
				duple.add(str);
				continue;
			}
			set.add(str);
		}
		for (String str : duple) {
			set.remove(str);
		}
		return set;
	}

	public static class TestClass {
		Solution s = new Solution();
//		@Test
//		public void test1() {
//			assertThat(new String[] {"sweet","sour"}, is(s.uncommonFromSentences("this apple is sweet", "this apple is sour")));
//		}
//		
//		@Test
//		public void test2() {
//			assertThat(new String[] {"banana"}, is(s.uncommonFromSentences("apple apple", "banana")));
//		}
		
		@Test
		public void test3() {
			assertThat(new String[] {"ejt"}, is(s.uncommonFromSentences("s z z z s", "s z ejt")));
		}
	}
}
