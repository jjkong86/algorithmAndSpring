package bookAlgorithms.sort;

import java.util.Random;

public class MyHeadSort {
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
		}
		
		StringBuilder print = new StringBuilder();
		for (int j = 0; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println("정렬 전 : ["+print+"]");
		
		MyHeadSort s = new MyHeadSort();
		s.sort(array);
	}

	private void sort(int[] array) {
		int len = array.length;
		
		for (int i = 1; i < len; i++) {
			int child = i;
			
			while (child > 0) {
				int parent = child/2;
				if (array[parent] > array[child]) {
					int temp = array[parent];
					array[parent] = array[child];
					array[child] = temp;
				}
				child = parent;
			}
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
