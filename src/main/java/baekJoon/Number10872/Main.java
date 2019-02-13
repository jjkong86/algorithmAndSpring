package baekJoon.Number10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int factorial(String str) {
		if (str.equals("0")) {
			return 1;
		}
		int num = Integer.parseInt(str);
		int result = 1;
		for (int i = 2; i <= num; i++) {
				result *= i;
		}
		return result;
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorial(br.readLine()));
		br.close();
	}
}