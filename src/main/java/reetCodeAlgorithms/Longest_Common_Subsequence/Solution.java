package reetCodeAlgorithms.Longest_Common_Subsequence;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int index = 0, count = 0;
		char[] leftChars = text1.toCharArray(), rightChars = text2.toCharArray();
		return findMaxSubsequence(leftChars, rightChars, leftChars.length-1, rightChars.length-1);
	}

	public int findMaxSubsequence(char[] leftChars, char[] rightChars) {
		int index = 0, count = 0;
		for (char leftChar : leftChars) {
			for (int j = index; j < rightChars.length; j++) {
				if (leftChar == rightChars[j]) {
					index = j + 1;
					count++;
				}
			}
		}

		return count;
	}

	public int findMaxSubsequence(char[] leftChars, char[] rightChars, int m, int n) {
		int[][] memo = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					memo[i][j] = 0;
				else if (leftChars[i - 1] == rightChars[j - 1])
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
			}
		}
		return memo[m][n];
	}

	public static class TestClass {

		@Test
		public void test1() {
			assertEquals(new Solution().longestCommonSubsequence("oxcpqrsvwf","shmtulqrypy"), 2);
		}
	}
}
