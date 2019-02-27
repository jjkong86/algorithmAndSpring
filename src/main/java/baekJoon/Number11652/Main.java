package baekJoon.Number11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
    public static long card(long[] array, int number) {
    	long minNumber = 0;
    	int maxCount = 0;
    	Map<Object, Integer> countMap = new HashMap<>();
    	for (int i = 0; i < number; i++) {
    		int count = 0;
    		long temp = array[i];
    		if (countMap.get(temp) != null) {
    			count = countMap.get(temp) + 1;
    		} else {
    			countMap.put(temp, 1);
    			count = 1;
    		}
    		if (count > maxCount) {
    			maxCount = count;
    			minNumber = temp;
    		} else if (count == maxCount) {
    			minNumber = minNumber > temp ? temp : minNumber;
    		}
			countMap.replace(temp, count);
		}
    	return minNumber;
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

