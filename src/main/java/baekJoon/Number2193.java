package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2193 {
	
	public static long pinaryNumber(int num) {
		//n-1에서 1로 끝나면 그대로 계승, 0으로 끝나면 +1
		//1 * num + 2 * num = num(홀수+짝수*2); 
		long[] oddEven = new long[2]; //[홀수, 짝수]
		oddEven[1] = 1;
		if (num < 3) {
			return 1;
		}
		
		for (int i = 3; i <= num; i++) {
			long temp = oddEven[1];
			oddEven[1] = oddEven[1] +oddEven[0];
			oddEven[0] = temp; 
		}
		return (oddEven[0]+oddEven[1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		System.out.println(pinaryNumber(number));
		br.close();
	}
}