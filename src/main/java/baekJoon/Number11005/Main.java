package baekJoon.Number11005;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static String convert(int[] array) {
        int b = array[1];
        int num = array[0];
        int[] saveArray = new int[101];
        int index = 0;
        while (b < num) {
            int quotient = num / b;
            int remainder = num - (b * quotient);
            saveArray[index++] = remainder;
            num = quotient;
        }
        saveArray[index] = num;
        String str = "";
        if (b > 10) {
			str = toString(saveArray);
		} else {
			str = IntStream.of(saveArray).toString();
			return str;
		}
        
        return str;
    }
    public static String toString(int[] array) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
    	
    	return "";
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
//        System.out.println(convert(array));
//        br.close();
    	int[] array = new int[2];
    	array[0] = 9;
    	array[1] = 3;
    	String str = IntStream.of(array).toString();
    	System.out.println(str);
    	
    }
    
}
