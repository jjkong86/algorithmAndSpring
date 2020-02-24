package reetCodeAlgorithms.Longest_Common_Subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int index = 0, count = 0;
		char[] leftChars = text1.toCharArray(), rightChars = text2.toCharArray();
		for (int i = 0; i < leftChars.length; i++) {
			for (int j = index; j < rightChars.length; j++) {
				if (leftChars[i] == rightChars[j]) {
					index = j + 1;
					count++;
				}
			}
		}

		return count;
	}

	public static class TestClass {

		@Test
		public void test1() {
			assertEquals(1, 1);
		}
	}
}
