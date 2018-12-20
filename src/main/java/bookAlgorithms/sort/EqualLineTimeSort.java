package bookAlgorithms.sort;

import java.util.Random;

public class EqualLineTimeSort {

	private static int[] wArray;
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		int target = 0;
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
			target = target != 0? target : gen.nextInt(10);
		}
		wArray = array;
		System.out.println("target index :"+target);
		int result = select(0, array.length-1, target);
		System.out.println("result : "+result);
//		System.out.println(result);
//		int[] arrayResult = quickSort(0, wArray.length-1);
//		print(arrayResult);
	}
	
	public static int select(int start, int end, int target) {
		if (start == end) return wArray[start];
		
		int q = partition(start, end);
		System.out.println(q);
		
		if (q == target) {
			return wArray[target];
		} else if (q > target){
			// 1,2,3 / 4 / 5,6,7 -> 5, 2
			select(start, q-1, target);
		} else if (q < target) {
			select(q+1, end, target);
		}
		
		return wArray[target];
	}

	private static int[] quickSort(int start, int end) {
		if (start < end) {
			int result = partition(start, end);
			System.out.println("targetIndex : "+result);
			quickSort(start, result-1);
			quickSort(result+1, end);
		}
		return wArray;
	}
	
	private static int partition(int start, int end) {
		// // 1구역 // target // 3구역 // 4구역(array 처음)
		int target = wArray[end]; // 맨 끝의 원소를 기준원소로 함
		System.out.println(target);
		int firstIndex = start;
		int thirdIndex = start;
		for (thirdIndex = start; thirdIndex < end; thirdIndex++) { // thirdIndex : 3구역의 시작 지점
			if (target >= wArray[thirdIndex]) {
				int temp = wArray[thirdIndex];
				wArray[thirdIndex] = wArray[firstIndex];
				wArray[firstIndex] = temp;
				firstIndex++;
			}
		}
		int temp = wArray[firstIndex];
		wArray[firstIndex] = wArray[thirdIndex];
		wArray[thirdIndex] = temp;
		
		print(wArray);
		return  firstIndex;
	}
	
	public static void print(int[] array) {
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}

}
