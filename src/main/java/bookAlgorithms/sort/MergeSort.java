package bookAlgorithms.sort;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[50];
		for (int i = 0; i < 50; i++) {
			array[i] = gen.nextInt(100);
		}
		MergeSort s = new MergeSort();
		s.sort(array);
	}

	private void sort(int[] array) {
		//배열을 반으로 나눠서 전반부, 후반부 정렬후 merge
		int middle = (array.length - 1)/2;
		int[] ret = new int[array.length];
		for (int i = 0; i <= middle; i++) {
			boolean flag = false;
			for (int j = 1; j <= middle - i; j++) {
				if (array[j-1] > array[j]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					flag = true;
				}
			}
			if(!flag) break;
		}

		int len = array.length -1;
		for (int i = middle+2; i <= len; i++) {
			boolean flag = false;
			for (int j = middle+2; j <= len - i + middle + 2; j++) {
				if (array[j-1] > array[j]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					flag = true;
				}
			}
			if(!flag) break;
		}

		int left = 0;
		int right = middle+1;
		int index = 0;
		while (left <= middle && right <= len) {
			if (array[left] > array[right]) {
				ret[index++] = array[right++];
			} else {
				ret[index++] = array[left++];
			}
		}

		while (left <= middle) {
			ret[index++] = array[left++];
		}

		while (right <= len) {
			ret[index++] = array[right++];
		}

		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
			if (array[j-1] > array[j]) {
				System.out.println("오름차순 정렬 실패 : "+array[j]+", index : "+j);
			}
		}
		System.out.println(print+"]");

	}

}
