package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number11727 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//2^n 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수
		//경우의 수를 10,007로 나눈 나머지를 출력
		//작은 크기부터 채워가면 ?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		long[] array = new long[1001];
		array[0] = 0;
		array[1] = 1;
		array[2] = 3;
		for (int i = 3; i <= input; i++) {
			array[i] = (array[i-1] +2* array[i-2])%10007;
		}
		System.out.println(array[input]);
	}
}
