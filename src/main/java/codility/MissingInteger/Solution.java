package codility.MissingInteger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	int index = 0;
	public int solution(int[] A) {
		// write your code in Java SE 8
		// 주어진 배열 요소 중 존재 하지 않은 최소값(0보다 큼)
		// 쉬운방법 부터 : 정렬 후 비교해봄
		if (A.length < 1) return 1;
		System.out.println(Arrays.toString(A));
		System.out.println("==================");
//		sort(A, 0, A.length-1);
		return minFind(A);
	}
	
	public void sort(int[] array, int left, int right) {
		if (right > left) {
			int p = partition(array, left, right);
			sort(array, left, p - 1);
			sort(array, p + 1, right);
		}
	}

	public int partition(int[] array, int left, int right) {
		// // 1구역 // target // 3구역 // 4구역(array 처음)
		int target = array[right]; // 맨 끝의 원소를 기준원소로 함
		System.out.println(target);
		int firstIndex = left;
		int thirdIndex = left;
		for (thirdIndex = left; thirdIndex < right; thirdIndex++) { // thirdIndex : 3구역의 시작 지점
			if (target >= array[thirdIndex]) {
				swap(array, firstIndex++, thirdIndex);
			}
		}
		swap(array, firstIndex, thirdIndex);
		return  firstIndex;
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public int minFind(int[] A) {
		if (A.length < 1) return 1;
        if (A.length < 2) return A[0] == 1 ? 2 : 1;
        
//        Set<Integer> set = new HashSet<>(Arrays.stream(A).boxed().filter(i -> i>0).collect(Collectors.toList()));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > 0) set.add(A[i]);
		}
//        System.out.println(set.toString());
        for (int i=1; i<=set.size(); i++) {
            if (!set.contains(i)) return i;
            if (i == set.size()) return i+1;
        }
        return 1;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {-1, -3}));
		
		int num = 10;
		int[] array = new int[num];
		Random ran = new Random();
		for (int i = 0; i < num; i++) {
			array[i] = ran.nextInt(5);
		}
		System.out.println(s.solution(array));
	}
}
