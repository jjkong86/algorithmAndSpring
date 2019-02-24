package baekJoon.Number10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	
    static int[] array;
    
    public static void sort(int[] array) {
    	IntStream.of(array).sorted().forEach(System.out::println);
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
            sort(array);
        }
    }
}
