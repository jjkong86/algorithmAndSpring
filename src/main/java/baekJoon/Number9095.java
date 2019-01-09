package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number9095 {
	private static int[] arrays;
	public static void sumCountCase(int value) {
		// 정수 n을 1,2,3의 합으로 나타내는 방법의 수
		// 1<= n < 11
		// value : 0 -> 0, value : 1 -> 1, value = 2 -> 2, value = 3 -> 4, value = 4 -> 7
		arrays = new int[(value + 1) < 4 ? 4 : (value +1)];
		arrays[0] = 0;
		arrays[1] = 1;
		arrays[2] = 2;
		arrays[3] = 4;
		for (int i = 4; i <= value; i++) {
			arrays[i] = arrays[i - 1] + arrays[i - 2] + arrays[i - 3];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringJoiner sj = new StringJoiner("\n");
		int[] answer = new int[input];
		int maxNum = 0;
		for (int i = 0; i < input; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 10) {
				continue;
			}
			answer[i] = num;
			if (num > maxNum) {
				maxNum = num;
			}
		}
		sumCountCase(maxNum); //가장 큰수 까지 배열 채움
		for (int i = 0; i < answer.length; i++) {
			int index = answer[i];
			if (index > 0) {
				sj.add(String.valueOf(arrays[index]));
			}
		}
		System.out.println(sj);
	}
}
