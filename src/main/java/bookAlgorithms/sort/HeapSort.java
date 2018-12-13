package bookAlgorithms.sort;

import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
		}
		HeapSort s = new HeapSort();
		s.sort(array);
		
		Heap h = new Heap();

	}

	private void sort(int[] array) {
		
	}

}
