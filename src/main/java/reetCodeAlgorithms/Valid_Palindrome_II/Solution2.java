package reetCodeAlgorithms.Valid_Palindrome_II;

import org.junit.Assert;
import org.junit.Test;

public class Solution2 {
    char[] chars;

    public boolean validPalindrome(String s) {
        chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        Pair pair = this.isPalindromeIndexOf(left, right);
        if (pair == null)
            return true;

        return isPalindrome(pair.getLeft() + 1, pair.getRight()) ||
                isPalindrome(pair.getLeft(), pair.getRight() - 1);
    }

    public boolean isPalindrome(int left, int right) {
        return this.isPalindromeIndexOf(left, right) == null;
    }

    public Pair isPalindromeIndexOf(int left, int right) {
        int count = -1;
        for (int i = left; i <= right; i++) {
            if (chars[i] != chars[right - ++count]) {
                //System.out.println(i + "::" + (right-count));
                return new Pair(i, right - count);
            }
        }

        return null;
    }


    public static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    public static class TestClass {
        Solution2 s = new Solution2();

        @Test
        public void test1() {
            Assert.assertTrue(s.validPalindrome("abca"));
        }

        @Test
        public void test2() {
            Assert.assertFalse(s.validPalindrome("abc"));
        }

        @Test
        public void test3() {
            Assert.assertTrue(s.validPalindrome("deeee"));
        }

        @Test
        public void test4() {
            Assert.assertTrue(s.validPalindrome("ebcbbececabbacecbbcbe"));
        }
    }
}
