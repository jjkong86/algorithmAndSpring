package bookAlgorithms.sort;

import java.util.Random;

public class EqualLineTimeSort {

	private int[] wArray;
	private int wTarget;
	
	public EqualLineTimeSort(int[] array, int target) {
		this.wArray = array;
		this.wTarget = target;
	}
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
		}
//		int result = e.select(array, 0, array.length-1, array[4]);
		
		int[] arrayResult = quickSort(array, 0, array.length-1);
		StringBuilder print = new StringBuilder("정렬 후 : ["+arrayResult[0]+", ");
		for (int j = 1; j < arrayResult.length; j++) {
			print.append(arrayResult[j]).append(j == arrayResult.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}
	
	public int select(int[] array, int start, int end, int target) {
		if (start == end) return array[start];
		
		int[] q = quickSort(array, start, end);
		return 0;
	}

	private static int[] quickSort(int[] array, int start, int end) {
		
		if (start < end) {
			EqualLineTimeSort result = partition(array, start, end);
			System.out.println("targetIndex : "+result.wTarget);
			quickSort(array, start, result.wTarget-1);
			quickSort(array, result.wTarget+1, end);
		}
		return array;
	}
	
	private static EqualLineTimeSort partition(int[] array, int start, int end) {
		int target = array[end]; // 맨 끝의 원소를 기준원소로 함
		System.out.println(target);
		int firstIndex = -1;
		int thirdIndex = 0;
		for (thirdIndex = start; thirdIndex < end; thirdIndex++) { // i : 3구역의 시작 지점
			if (target >= array[thirdIndex]) {
				firstIndex++;
				int temp = array[thirdIndex];
				array[thirdIndex] = array[firstIndex];
				array[firstIndex] = temp;
			}
		}
		int temp = array[firstIndex];
		array[firstIndex] = array[thirdIndex];
		array[thirdIndex] = temp;
		
		return new EqualLineTimeSort(array, firstIndex);
	}

}
