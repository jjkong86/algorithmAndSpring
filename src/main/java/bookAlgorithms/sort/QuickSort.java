package bookAlgorithms.sort;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
		}
		QuickSort s = new QuickSort();
		s.sort(array);
	}

	private void sort(int[] array) {
		//1,2,11,9,8 -> 하나의 숫자를 임으로 지정(보통 마지막 수)하여 그 수보다 작은쪽과 큰쪽으로 나누고 정렬함 1,2,3,4구역으로 나눠서 하면 편함
		//1구역의 마지막 index, 3구역의 시작 index 알아야함..

		int len = array.length-1;
		int standard = array[len];
		System.out.println(standard);
		int firstIndex = 0;
		int thirdIndex = 0;

		for (int i = 0; i <= len; i++) {
			if (array[i] <= standard) {
				int temp = array[thirdIndex];
				array[thirdIndex] = array[firstIndex];
				array[firstIndex] = temp;
				firstIndex ++;
				thirdIndex ++;
			} else {
				thirdIndex ++;
			}
		}

		int middle = firstIndex-1;
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
