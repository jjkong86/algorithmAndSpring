package baekJoon.Number1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int factorialFindZero(String str) {
		// ex) 3628800 -> 0이 2개
		// 10의 자리가 나와야함 -> 2*5(모두 곱셈이기 때문)
		// 2 * 5 조합 개수만큼 0이 나옴
		
		if (str.equals("0")) {
			return 0;
		}
		int num = Integer.parseInt(str);
		int Number2Count = 0;
		int Number5Count = 0;
		
		for (int i=1; i<=num; i++) {
			int temp = i;
			while (temp != 0 && temp != 1) {
				if (temp % 2 == 0) {
					Number2Count ++;
					temp = temp / 2;
				} else if (temp % 5 == 0) {
					Number5Count ++;
					temp = temp / 5;
				} else {
					break;
				}
			}
		}
		
		return Math.min(Number2Count, Number5Count);
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorialFindZero(br.readLine()));
		br.close();
	}
}