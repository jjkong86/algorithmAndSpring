package baekJoon.Number2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static String sort(int[] array) {
		StringBuilder sb = new StringBuilder();
		int len = array.length;
		array = heapSort(array, len);
		for (int i = len - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;

			array = heapSort(array, i);
		}

		for (int i = 0; i < len; i++) {
			sb.append(array[i] + "\n");
		}
		return sb.toString();
	}

	public static int[] heapSort(int[] array, int len) {
		// heap build -> 오름차순이면 내림차순으로 빌드 하고 len ~ 0 까지 오름차순으로 다시 빌드
		// heap build = array[0] 은 array[1], array[2]의 부모 ...
		for (int i = 1; i < len; i++) { 
			int child = i;
			while (child > 0) {
				int parent = child / 2;
				int temp = array[parent];
				if (array[child] > temp) {
					array[parent] = array[child];
					array[child] = temp;
				} else {
					break;
				}
				child = parent;
			}
		}
		return array;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] array = new int[number];
		for (int i = 0; i < number; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(sort(array));
		br.close();
	}
}
