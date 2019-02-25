package baekJoon.Number10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main2 {
	
	static int[] array;
	
	private static void sort(int[] array, int left, int right) {
		if (right > left) {
			int partition = partition(array, left, right);
			sort(array, 0, partition -1);
			sort(array, partition +1, right);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		int middle = array[left+right/2];
		while (right > left) {
			while (array[left] < middle && right > left) left++;
			while (array[right] > middle && right > left) right--;
			
			while (right > left) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		
		return left;
	}
	
	
	public static void main(String[] args) throws IOException, NumberFormatException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(br.readLine());
            array = new int[number];
            IntStream.range(0, number).forEach(i -> {
				try {
					array[i] = Integer.parseInt(br.readLine());
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			});
            sort(array, 0, number -1);
        }
    }
}
