package baekJoon.Number2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static int sumDvide(int number, int targetSum) {
		
		return 0;
	}
	
	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input= Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
		System.out.println(sumDvide(input[0], input[1]));
		br.close();
	}
}
