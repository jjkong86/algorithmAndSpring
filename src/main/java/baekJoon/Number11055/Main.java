package baekJoon.Number11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static int maxSum(int[] array) {
		int len = array.length;
		int[] sumArray = new int[len];
		sumArray[0] = array[0];
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && sumArray[i] < sumArray[j]+array[i]) {
					sumArray[i] = sumArray[j]+array[i];
				}
			}
		}
		return IntStream.of(sumArray).max().getAsInt();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] array = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		System.out.println(maxSum(array));
		br.close();
	}
}
