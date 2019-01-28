package baekJoon.Number1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String calculator(String str) {
        // 8진수 -> 2진수 변환
        // 수가 0인 경우 제외하고 1로 시작
    	if (str.equals("0") || str.equals(" ") || str.equals("")) {
			return "0";
		}
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            char temp = str.charAt(i);
            sb.append(convert(temp, i == 0 ? true : false));
        }
       return sb.toString();
    }
    public static String convert(char c, boolean flag) {
        int number = c - '0';
        StringBuilder sb = new StringBuilder();
        while (number >0) {
            int temp = number/2;
            int extra = number - temp*2;
            number = number / 2;
            sb.append(extra);
        }
        if (sb.length() < 3) {
			while (sb.length() < 3) {
				sb.append(0);
			}
		}
        if (flag) {
        	return String.valueOf((Integer.parseInt(sb.reverse().toString())));
		} else {
			return sb.reverse().toString();
		}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculator(br.readLine()));
        br.close();
    }
}
