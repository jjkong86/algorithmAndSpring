package bookAlgorithms.sort;

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[50];
		for (int i = 0; i < 50; i++) {
			array[i] = gen.nextInt(100);
		}
		InsertionSort s = new InsertionSort();
		s.sort(array);

	}

	private void sort(int[] array) {
		int len = array.length-1;
		
		for (int i = 1; i <= len; i++) {
			
			if (array[i] > array[i-1]) {
				continue;
			}
			for (int j = i; j > 0; j--) {
				if (array[j] > array[j-1]) {
					break;
				}
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
			}
		}
		
		StringBuilder print = new StringBuilder("[");
		for (int j = 0; j < array.length; j++) {
			print.append(array[j]+",");
		}
		System.out.println(print);
	}

}
