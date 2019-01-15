package reetCodeAlgorithms.Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public int longestValidParentheses(String s) {
		if(s.length() < 1) return 0;

		 int maxans = 0;
	        Stack<Integer> stack = new Stack<>();
	        stack.push(-1);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {
	                stack.pop();
	                if (stack.empty()) {
	                    stack.push(i);
	                } else {
	                    maxans = Math.max(maxans, i - stack.peek());
	                }
	            }
	        }
	        return maxans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestValidParentheses(")))())((())"));
	}

}
