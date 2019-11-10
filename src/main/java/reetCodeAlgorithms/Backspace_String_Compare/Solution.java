package reetCodeAlgorithms.Backspace_String_Compare;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
	public boolean backspaceCompare(String S, String T) {
		StringBuilder sbS = new StringBuilder();
		StringBuilder sbT = new StringBuilder();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (sbS.length() > 0)
					sbS.deleteCharAt(sbS.length() - 1);
			} else
				sbS.append(String.valueOf(S.charAt(i)));
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#') {
				if (sbT.length() > 0)
					sbT.deleteCharAt(sbT.length() - 1);
			} else
				sbT.append(String.valueOf(T.charAt(i)));
		}

		return sbS.toString().equals(sbT.toString());
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(true, is(s.backspaceCompare("y#fo##f", "y#f#o##f")));
		}

	}
}
