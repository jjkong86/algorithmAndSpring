package reetCodeAlgorithms.Longest_Valid_Parentheses;

import java.util.Stack;

public class Solution2 {
	
	public int longestValidParentheses(String s) {
		if(s.length() < 1) return 0;
		
		Stack<Integer> stack = new Stack<>();
		int maxCount = 0;
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				}
				maxCount = Math.max(maxCount, i - stack.peek());
			}
			
		}
		
		return maxCount;
	}
    
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.longestValidParentheses("()(()("));
	}

}
