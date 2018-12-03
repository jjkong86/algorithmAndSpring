package reetCodeAlgorithms.Valid_Parentheses;

import java.util.Stack;

public class testew {

	public static void main(String[] args) {
		String s = "(){}()[]";
		Stack<Character> stack = new Stack<>();
        boolean flag = true;
		
        for (Character c : s.toCharArray()) {
            if('(' == c) {
                stack.push(')');
            } else if('{' == c) {
                stack.push('}');
            } else if('[' == c) {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != c) {
            	flag = false;
                break;
            }
        }
        System.out.println(stack.empty() && flag);
	}

}
