package reetCodeAlgorithms.Buddy_Strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

class Solution {
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.equals(B)) {
			Set<Character> s = new HashSet<Character>();
			for (char c : A.toCharArray())
				s.add(c);
			return s.size() < A.length();
		}
		List<Integer> dif = new ArrayList<>();
		for (int i = 0; i < A.length(); ++i)
			if (A.charAt(i) != B.charAt(i))
				dif.add(i);
		
		return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1))
				&& A.charAt(dif.get(1)) == B.charAt(dif.get(0));
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(true, is(s.buddyStrings("ab", "ba")));
		}

		@Test
		public void test2() {
			assertThat(false, is(s.buddyStrings("ab", "ab")));
		}

		@Test
		public void test3() {
			assertThat(true, is(s.buddyStrings("aaaaaaabc", "aaaaaaacb")));
		}

		@Test
		public void test4() {
			assertThat(true, is(s.buddyStrings("aaaaaaabcaa", "aaaaaaacbaa")));
		}

	}
}
