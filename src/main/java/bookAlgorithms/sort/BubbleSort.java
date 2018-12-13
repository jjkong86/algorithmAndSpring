package bookAlgorithms.sort;

import java.util.Random;

public class BubbleSort {
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[50];
		for (int i = 0; i < 50; i++) {
			array[i] = gen.nextInt(100);
		}
		BubbleSort s = new BubbleSort();
		s.sort(array);
	}

	private void sort(int[] array) {
		boolean sorted = false;
		int len = array.length -1;
		for (int i = 0; i < len; i++) {
			
			for (int j = 1; j < len -i; j++) {
				if (array[j-1] > array[j]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					sorted = true;
				}
			}
			
			if (!sorted) {
				break;
			}
		}
		StringBuilder print = new StringBuilder("[");
		for (int j = 0; j < array.length; j++) {
			print.append(array[j]+",");
		}
		System.out.println(print);
	}
}
