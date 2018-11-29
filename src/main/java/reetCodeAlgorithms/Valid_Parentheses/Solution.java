package reetCodeAlgorithms.Valid_Parentheses;

import java.util.Stack;

public class Solution {
	
	public boolean isValid(String s) {
		//stack 이용
		//
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if ('(' == c) {
				stack.push(')');
			} else if ('{' == c) {
				stack.push('}');
			} else if ('[' == c) {
				stack.push(']');
			} else if(stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
		
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("()[]{}"));
	}
}
