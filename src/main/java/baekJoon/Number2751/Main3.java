package baekJoon.Number2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
	
	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int middle = partition(array, left, right);
			quickSort(array, left, middle-1);
			quickSort(array, middle+1, right);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		// 1 / 2 / 3 / 4 구역
		// 기준 숫자보다 작으면 1구역, 크면 2구역, 마지막엔 1구역+1 <-> 기준숫자
		//
		int standard = array[right];
		int firstIdx = left;
		int thirdIdx = left;
		
		for (thirdIdx = left; thirdIdx<=right; thirdIdx++) {
			if (standard > array[thirdIdx]) {
				int temp = array[firstIdx];
				array[firstIdx] = array[thirdIdx];
				array[thirdIdx] = temp;
				firstIdx ++;
			}
		}
		
		array[right] = array[firstIdx];
		array[firstIdx] = standard;
		
		return firstIdx;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] array = new int[number];
		for (int i = 0; i < number; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		quickSort(array, 0, number-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(array[i] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
