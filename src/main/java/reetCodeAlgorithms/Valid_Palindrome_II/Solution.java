package reetCodeAlgorithms.Valid_Palindrome_II;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
	public boolean validPalindrome(String s) {
		// 회문이 아닌지 맞는지 판단이므로 회문의 최대값부터 시작?
		// 짝수 일 때 왼쪽의 비교 대상 문자가 중앙값인지 판단 -> 문자열 길이가 홀수가 되기 때문 비교 문자가 없음
		// abcdccba
		int i = 0, j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}

		if (i >= j)
			return true;

		if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1))
			return true;
		return false;
	}

	private boolean isPalin(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(true, is(s.validPalindrome("abca")));
		}

		@Test
		public void test2() {
			assertThat(false, is(s.validPalindrome("abc")));
		}

		@Test
		public void test3() {
			assertThat(true, is(s.validPalindrome("deeee")));
		}

		@Test
		public void test4() {
			assertThat(true, is(s.validPalindrome("ebcbbececabbacecbbcbe")));
		}

	}
}
