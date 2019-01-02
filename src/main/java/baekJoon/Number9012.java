package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Number9012 {

	public static String stackAble(String str) {
		// ( 로 들어오면 스텍에 ) push -> 아니면 ) 꺼내야함
		// 반복문이 다 돌고 나서 st가 비어있어야 성공임
		// 
		Stack<String> st = new Stack<>();
		boolean flag = false;
		for (char temp : str.toCharArray()) {
			if ('(' == temp) {
				st.push("(");
			} else {
				if (st.empty()) {
					st.push("(");
					break;
				} else {
					st.pop();
				}
			}
		}
		
		if (st.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag == false ? "NO" : "YES";
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len;
		try {
			len = Integer.parseInt(br.readLine());
			for (int i = 0; i < len; i++) {
				System.out.println(stackAble(br.readLine()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String[] str = {"(())())", "(((()())()", "(()())((()))", "((()()(()))(((())))()", "()()()()(()()())()", "(()((())()("};
//		for (int i = 0; i < str.length; i++) {
//			System.out.println(stackAble(str[i]));
//		}
	}

}
