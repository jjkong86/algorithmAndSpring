package bookAlgorithms.sort;

import java.util.Random;

public class EqualLineTimeSort {

	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
		}
		EqualLineTimeSort e = new EqualLineTimeSort();
		int result = e.select(array, array[0], array.length-1, array[4]);
		System.out.println(result);
	}
	
	public int select(int[] array, int start, int end, int target) {
		if (start == end) return array[start];
		
		int[] q = quickSort(array, start, end);
		return 0;
	}

	private int[] quickSort(int[] array, int start, int end) {
		partition(array, start, end);
		
		return array;
	}
	
	private int partition(int[] array, int start, int end) {
		int target = array[end]; // 맨 끝의 원소를 기준원소로 함
		System.out.println(target);
		int firstIndex = 0;
		int thirdIndex = 0;
		for (thirdIndex = start; thirdIndex < end; thirdIndex++) { // i : 3구역의 시작 지점
			if (target <= array[thirdIndex]) {
				int temp = array[thirdIndex];
				array[thirdIndex] = array[firstIndex];
				array[firstIndex] = temp;
				firstIndex ++;
			}
		}
		int temp = array[firstIndex+1];
		
		
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
		
		return firstIndex+1;
	}

}
