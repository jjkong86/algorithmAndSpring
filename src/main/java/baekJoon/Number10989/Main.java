package baekJoon.Number10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
    public static StringBuilder sort(int[] array, int number) {
    	Arrays.sort(array);
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<number; i++) {
    		sb.append(array[i]).append("\n");
    	}
    	return sb;
    }
    public static void main(String[] args) throws IOException, NumberFormatException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(br.readLine());
            int[] array = new int[number];
            for (int i = 0; i < number; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
            System.out.println(sort(array, number));
        }
    }
}
