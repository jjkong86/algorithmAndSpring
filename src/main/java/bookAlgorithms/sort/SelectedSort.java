package bookAlgorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SelectedSort {
	
	public int[] selSort(int[] array) {
		List<Integer> list = new ArrayList<>();
		for (int i : array) {
			list.add(i);
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			int jLen = list.size()- 1 - i;
			int maxInt = 0;
			int tempIndex = 0;
			for (int j = 0; j <= jLen; j++) {
				if (list.get(j) >= maxInt) {
					maxInt = list.get(j);
					tempIndex = j;
				}
				if (j == jLen) {
					int tempInt = list.get(jLen);
					list.set(jLen, maxInt);
					list.set(tempIndex, tempInt);
				}
			}
		}
		System.out.println(list);
		
		
		return null;
	}
	
	public int[] sort(int[] array, int len) {
		if (len < 0) return array;
		int max = 0;
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		int temp = array[index];
		array[index] = array[len];
		array[len] = temp;
		
		sort(array, len -1);
		
		return array;
	}
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[50];
		for (int i = 0; i < 50; i++) {
			array[i] = gen.nextInt(100);
		}
		SelectedSort s = new SelectedSort();
//		s.selSort(array);
		int[] result = s.sort(array, array.length-1);
		
		StringBuilder print = new StringBuilder("정렬 후 : ["+result[0]+", ");
		for (int j = 1; j < result.length; j++) {
			print.append(result[j]).append(j == result.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
		
	}
}
