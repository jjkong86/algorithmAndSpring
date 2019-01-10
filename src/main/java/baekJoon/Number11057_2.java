package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11057_2 {
	
	public static int numberClimbs(int num) {
		//dp[i] = sum(dp[i-1]) - sum(dp[i-2])
		int[] arrays = new int[10];
		int[] savedArrays = new int[10];
		int initSum = 0;
		for (int i = 0; i < 10; i++) {
			arrays[i] = 1;
			initSum += 1;
		}
		int sum = initSum;
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					savedArrays[j] = sum;
					sum = 0;
				} else {
					savedArrays[j] = ((savedArrays[j-1]+10007) - arrays[j-1])%10007;
					arrays[j-1] = savedArrays[j-1];
				}
				sum = (sum + savedArrays[j])%10007;
			}
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
