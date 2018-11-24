package bookAlgorithms;

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
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[50];
		for (int i = 0; i < 50; i++) {
			array[i] = gen.nextInt(100);
		}
		SelectedSort s = new SelectedSort();
		s.selSort(array);
		
	}
}
