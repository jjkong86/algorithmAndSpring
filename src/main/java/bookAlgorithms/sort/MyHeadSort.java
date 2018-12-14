package bookAlgorithms.sort;

import java.util.Random;

public class MyHeadSort {
	public static void main(String[] args) {
		/*
		 * 힙을 이용하여 오름차순 정렬
		 * 먼저 힙을 내림차순으로 빌드함(힙의 속성을 만족해야함)
		 * 그리고 최초의 루트 노드와 맨끝에 있는 원소와 교환하고 다시 힙정렬 -> ex array[0] <-> array[9] ---> array[0] <-> array[8] .... ---> 정렬 끝
		 */
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
		array = s.sort(array, array.length-1);
		
		for (int i = array.length-1; i >= 0 ; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			
			s.sort(array, i);
		}
		
		print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
			if (array[j-1] > array[j]) {
				System.out.println("오름차순 정렬 실패 : "+array[j]+", index : "+j);
			}
		}
		System.out.println(print+"]");
	}

	private int[] sort(int[] array, int len) {
		
		for (int i = 1; i < len; i++) {
			int child = i;
			
			while (child > 0) {
				int parent = child/2;
				if (array[child] > array[parent]) {
					int temp = array[parent];
					array[parent] = array[child];
					array[child] = temp;
				}
				child = parent;
			}
		}
		return array;
	}
}
