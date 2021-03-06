package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11057 {
	
	public static int numberClimbs(int num) {
		int[][] arrays = new int[num+1][10];
		for (int i = 0; i < 10; i++) {
			arrays[1][i] = 1;
		}
		
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j < 10; j++) {
				int sum = 0;
				for (int j2 = j; j2 < 10; j2++) {
					sum = (sum + arrays[i-1][j2])%10007;
				}
				arrays[i][j] = sum;
			}
		}
		
		int sum=0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + arrays[num][i])%10007;
		}
		return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//오름차순으로 된 수의 갯수(같은 숫자도 오름차순으로 친다는 규칙)
		//수는 0으로 시작 할 수 있다. 1<=n<=1000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		System.out.println(numberClimbs(number));
		br.close();
	}
}
