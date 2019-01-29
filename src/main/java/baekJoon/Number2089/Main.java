package baekJoon.Number2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String calculator(int num) {
        //숫자를 -2 음수로 나눠서 -2진수로 만듬
        //나눠지는 숫자가 양수 일때와 음수일때 나눠야함
		if (num == 0) {
			return "0";
		}
       StringBuilder sb = new StringBuilder();
       int devide = -2; 
       while(num !=0)  {
    	   sb.append(num % 2 == 0 ? 0 : 1);
           num = num > 0 ? num / devide : num % devide == 0 ? num / devide : (num / devide) + 1;
       }
       
        return sb.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculator(Integer.parseInt(br.readLine())));
        br.close();
    }
}
