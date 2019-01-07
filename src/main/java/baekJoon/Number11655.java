package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11655 {

	public static void main(String[] args) throws IOException {
		//ROT13 -> 알파벳을 13글자씩 밀어서 만듬
		//대문자와 소문자를 구분, 다른 글자는 그대로 남아야함 -> 대문자 65 ~ 90, 소문자 97 ~ 122 -> 26개, 숫자 : 48 ~ 57
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : input) {
			if (Character.isUpperCase(c)) {
				sb.append((char)divide(c, 65));
			} else if (Character.isLowerCase(c)) {
				sb.append((char)divide(c, 97));
			} else if (Character.isDigit(c)) {
				sb.append(c);
			} else if (c == ' ') {
				sb.append(c);
			}
		}
		br.close();
		System.out.println(sb);
	}
	
	public static int divide(char val, int divideVal) {
		int value = (val+13) - divideVal;
		return (value%26)+divideVal;
	}

}
