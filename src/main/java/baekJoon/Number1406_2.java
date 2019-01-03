package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Number1406_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int inputL = input.length();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack_R = new Stack<>();
        
        for(int i=0;i<inputL;i++) {
            stack.push(input.charAt(i));
        }
        
        int len=Integer.parseInt(br.readLine());
        while(len-- > 0) {
            String order = br.readLine();
            switch (order) {
			case "L":
				if(!stack.empty()) {
                    stack_R.push(stack.pop());
                }
				break;
			case "D":
				if(!stack_R.empty()) {
                    stack.push(stack_R.pop());
                }
				break;
			case "B":
				if(!stack.empty()) {
                    stack.pop();
                }
				break;
			default:
				if (order.startsWith("P")) {
					char x = order.charAt(2);
	                stack.push(x);
				}
				break;
			}
        }
 
        while(!stack.empty()) {
            stack_R.push(stack.pop());
        }
 
        StringBuilder sb = new StringBuilder();
        while(!stack_R.empty()) {
            sb.append(stack_R.pop());
        }
        System.out.println(sb);
	}
}
