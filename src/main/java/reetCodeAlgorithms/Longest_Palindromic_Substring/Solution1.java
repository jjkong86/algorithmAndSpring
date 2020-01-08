package reetCodeAlgorithms.Longest_Palindromic_Substring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution1 {
	char[] chars;

	public String longestPalindrome(String s) {
		if (s == null || "".equals(s))
			return "";
		int max = 0;
		chars = s.toCharArray();
		int len = chars.length;
		int maxLeft = 0, maxRight = 0;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i + 1 > max && isPalindrome(i, j)) {
					max = Math.max(max, (j - i + 1));
					maxLeft = i;
					maxRight = j;
				}
			}
		}
		return makeString(maxLeft, maxRight);
	}

	private boolean isPalindrome(int left, int right) {
		int len = (right - left) / 2;
		for (int i = 0; i <= len; i++) {
			if (chars[left + i] != chars[right - i])
				return false;
		}
		return true;
	}

	private String makeString(int left, int right) {
		StringBuilder sb = new StringBuilder();
		for (int i = left; i <= right; i++) {
			sb.append(String.valueOf(chars[i]));
		}
		return sb.toString();
	}

	public static class ClassTest {
		Solution1 s = new Solution1();

		@Test
		public void test1() {
			assertThat("bab", is(s.longestPalindrome("babad")));
		}

		@Test
		public void test2() {
			assertThat("bb", is(s.longestPalindrome("cbbd")));
		}
	}
}
