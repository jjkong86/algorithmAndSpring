package baekJoon.Number11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static int vitonicSequence(int[] array) {
		// 수열 S가 어떤 수 Sk를 기준으로 S[1] < S[2] < ... S[k-1] < S[k] > S[k+1] > ... S[N-1] > S[N]을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
		// 바이토닉을 만족하는 최대 길이(연속적이지 않아도 된다)
		// 수열 A의 크기 N -> 1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000
		// 앞, 뒤에서 시작하고 더한값에 -1

		int len = array.length;
		int[] dpLeft = new int[len];
		int[] dpRight = new int[len];
		dpLeft[0] = 1;
		dpRight[len-1] = 1;
		
		for (int i = 1; i < len; i++) {
			dpLeft[i] = 1;
			int reverseI = len-i-1;
			dpRight[reverseI] = 1;
			for (int j = 0; j < i; j++) {
				int reverseJ = len-j-1;
				
				//왼쪽부터 증가하는 부분
				if (array[i] > array[j] && dpLeft[i] < dpLeft[j]+1) {
					dpLeft[i] = dpLeft[j] + 1;
				}
				//오른쪽부터 증가하는 부분
				if (array[reverseI] > array[reverseJ] && dpRight[reverseI] < dpRight[reverseJ]+1) {
					dpRight[reverseI] = dpRight[reverseJ] + 1;
				}
			}
		}
		
		int[] result = new int[len];
		IntStream.range(0, dpLeft.length).forEach(i -> result[i] = dpLeft[i]+dpRight[i]);
		return IntStream.of(result).max().getAsInt() - 1; 
	}

	public static void main(String[] a) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] array = Stream.of(input).mapToInt(Integer::parseInt).toArray();
		System.out.println(vitonicSequence(array));
		br.close();
	}
}
