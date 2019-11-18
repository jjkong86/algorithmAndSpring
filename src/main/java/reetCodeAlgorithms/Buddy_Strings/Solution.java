package reetCodeAlgorithms.Buddy_Strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
	public boolean buddyStrings(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		if (aLen != bLen) return false;
		
		StringBuilder notEq = new StringBuilder();
		String tempB = b;
		for (int i = 0; i < aLen; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				notEq.append(String.valueOf(a.charAt(i)));
			} else {
				tempB = tempB.replaceFirst(String.valueOf(a.charAt(i)), "");
			}
		}
		return notEq.reverse().toString().equals(tempB);
	}
	
	public static class TestClass {
		Solution s = new Solution();
		@Test
		public void test1() {
			assertThat(true, is(s.buddyStrings("ab", "ba")));
		}
		
		@Test
		public void test2() {
			assertThat(true, is(s.buddyStrings("ab", "ab")));
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
