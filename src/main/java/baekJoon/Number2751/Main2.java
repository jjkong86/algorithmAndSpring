package baekJoon.Number2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void quickSort(int[] array, int left, int right) {
		if (right > left) {
			int middle = partition(array, left, right);
			quickSort(array, left, middle - 1);
			quickSort(array, middle + 1, right);
		}
	}

	public static int partition(int array[], int left, int right) {
		// 기준이 되는 수를 정하여 왼쪽보다 크면 left++, 기준이 되는 수의 오른쪽이 기준수보다 크면 right--
		int middle = array[(left + right) / 2];
		while (left < right) {

			while (array[left] < middle && left < right) {
				left++;
			}
			while (array[right] > middle && left < right) {
				right--;
			}

			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}

		return left;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] array = new int[number];
		for (int i = 0; i < number; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		quickSort(array, 0, number - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(array[i] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
