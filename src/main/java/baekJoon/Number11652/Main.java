package baekJoon.Number11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
    public static StringBuilder card(long[] array, int number) {
    	int maxCount = 0;
    	int minNumber = 0;
    	int[] cardCount = new int[number];
    	int cardIndex = 0;
    	for (int i = 0; i < number; i++) {
			
		}
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<number; i++) {
    		sb.append(array[i]).append("\n");
    	}
    	return sb;
    }
    
    public static void main(String[] args) throws IOException, NumberFormatException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(br.readLine());
            long[] array = new long[number];
            for (int i = 0; i < number; i++) {
				array[i] = Long.parseLong(br.readLine());
			}
            System.out.println(card(array, number));
        }
    }
}

