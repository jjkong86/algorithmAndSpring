package reetCodeAlgorithms.Remove_Outermost_Parentheses;

// 괄호로 감싸져 있는 문자열을 반환함
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {
    private final char LEFT = '(';
    private final char RIGHT = ')';
    StringBuilder sb = new StringBuilder();

    public String removeOuterParentheses(String S) {
        String BLANK = "";
        if (S == null || S.equals(BLANK))
            return BLANK;

        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();

        for (char c : chars) {
            popAndPush(stack, c);
        }
        return sb.toString();
    }

    private void popAndPush(Stack<Character> stack, char c) {
        if (c == LEFT) {
            this.pop(stack);
        } else {
            this.push(stack);
        }
    }

    private void pop(Stack<Character> stack) {
        if (!stack.isEmpty())
            sb.append(LEFT);

        stack.push(RIGHT);
    }

    private void push(Stack<Character> stack) {
        stack.pop();
        if (!stack.isEmpty())
            sb.append(RIGHT);
    }

    public static class TestClass {
        Solution s = new Solution();
        @Test
        public void test1() {
            Assert.assertEquals(s.removeOuterParentheses("(()())(())(()(()))"), "()()()()(())");
        }
    }
}
