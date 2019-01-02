package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Number10799 {
	public static int stickCount(String str) {
		//막대를 나누면 +1
		//스택으로 구현 하고 나눠지면("()") -> "("가 들어있는 숫자 만큼 더해준다. 개수 : 3, +2, 개수 : (3 -1 +1), +3, +2, 개수 : 3 - 3 + 1, +1 = 17 
		Stack<String> stack = new Stack<>();
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('(' == c) {
				stack.push("(");
			} else {
				if (str.charAt(i-1) == '(') {
					count += stack.size()-1;
				} else {
					count++;
				}
				stack.pop();
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(stickCount(str));
	}

}
