package baekJoon.Number10989;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main2 {
	
	static int[] array;
	
	private static void sort(int left, int right) {
		if (right > left) {
			int partition = partition(array, left, right);
			sort(0, partition -1);
			sort(partition +1, right);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		int midIndex = (left+right)/2;
		System.out.println(array[midIndex]);
		while (right > left) {
			while (array[left] < array[midIndex] && right > left) {
				left++;
			}
			while (array[right] > array[midIndex] && right > left) {
				right--;
			}
			
			if (right > left) {
				swap(array, left, right);
			}
		}
		
		swap(array, left, midIndex);
		
		return left;
	}
	
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	
	public static void main(String[] args) throws IOException, NumberFormatException{
        int number = 10;
        array = new int[number];
        Random ran = new Random();
        for (int i = 0; i < number; i++) {
			array[i] = ran.nextInt(100);
		}
        System.out.println(Arrays.toString(array));
        System.out.println("=========================");
        sort(0, number -1);
        System.out.println(Arrays.toString(array));
    }
}
