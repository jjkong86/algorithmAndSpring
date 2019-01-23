package baekJoon.Number2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static int maxHeight(int[] array, int aim, int max) {
		int left = 0;
		int right = max;
		int height = 0;
		while (left <= right) {
			long sum = 0;
			int middle = (left+right)/2;
			for (int i = array.length-1; i>=0; i--) {
				if (array[i] > middle) {
					sum += array[i] - middle;
				} else {
					break;
				}
			}
			if (sum >= aim) {
				height = Math.max(height, middle);
				left = middle + 1;
			} else {
				right = middle -1;
			}
		}
		
		return height;
	}
	
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		int[] intArray = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		Arrays.sort(intArray);
		int max = intArray[input[0]-1];
		System.out.println(maxHeight(intArray, input[1], max));
		br.close();
	}
}
