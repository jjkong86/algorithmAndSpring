package baekJoon.Number11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
	public static int maxLen(int[] array) {
		//숫자 증가가 연속적이지 않아도 됨
		//dp문제
		int len = array.length;
		int[] lenArray = new int[len];
		Arrays.fill(lenArray, 1);
		int max = 0;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && lenArray[i] < lenArray[j]+1) {
					lenArray[i] = lenArray[j] + 1;
				}
			}
			if (lenArray[i] > max) {
				max = lenArray[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] array = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		System.out.println(maxLen(array));
		br.close();
	}
}
