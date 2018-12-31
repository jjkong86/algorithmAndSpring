package baekJoon;

import java.util.Random;
import java.util.Scanner;

public class Number2751 {
	
private static int[] wList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] list = new int[len];
        Random gen =  new Random();
        for (int i=0; i<len; i++) {
            int input = sc.nextInt();
        	list[i] = input;
        }
        wList = list;
        list = quickSort(0, wList.length-1);
        
        for (int i=0; i<len; i++) {
            System.out.println(list[i]);
        }
        
        sc.close();
	}
	private static int[] quickSort(int start, int end) {
		if (start < end) {
			int result = partition(start, end);
			quickSort(start, result-1);
			quickSort(result+1, end);
		}
		return wList;
	}

	private static int partition(int start, int end) {
		// // 1구역 // target // 3구역 // 4구역(array 처음)
		int target = wList[end]; // 맨 끝의 원소를 기준원소로 함		
		int firstIndex = start;
		int thirdIndex = start;
		for (thirdIndex = start; thirdIndex < end; thirdIndex++) { // thirdIndex : 3구역의 시작 지점
			if (target >= wList[thirdIndex]) {
				int temp = wList[thirdIndex];
				wList[thirdIndex] = wList[firstIndex];
				wList[firstIndex] = temp;
				firstIndex++;
			}
		}
		int temp = wList[firstIndex];
		wList[firstIndex] = wList[thirdIndex];
		wList[thirdIndex] = temp;
		return  firstIndex;
	}
}
