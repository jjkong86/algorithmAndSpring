package baekJoon.Number11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	
	public static int sortAndFindNumberIndex(int[] array, int index) {
		Arrays.sort(array);
		return array[index-1];
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] split = br.readLine().split(" ");
			int len = Integer.parseInt(split[0]);
			int index = Integer.parseInt(split[1]);
			String[] intSplit = br.readLine().split(" ");
			int[] array = new int[len];
			IntStream.range(0, len).forEach(i -> array[i] = Integer.parseInt(intSplit[i]));
			
			System.out.println(sortAndFindNumberIndex(array, index));
		}
	}
}
