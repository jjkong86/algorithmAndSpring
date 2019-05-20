package baekJoon.Number1920;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main2 {
    
    public static String findNumber(int[] array, int[] arrayAns) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < arrayAns.length; i++) {
        	sb.append((Arrays.binarySearch(array, arrayAns[i]) >= 0 ? 1 : 0)+ "\n");
		}
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] array = new int[len];
            makeArray(array, split, len);
            
            int ansLen = Integer.parseInt(br.readLine());
            String[] ansSplit = br.readLine().split(" ");
            int[] arrayAns = new int[ansLen];
            makeArray(arrayAns, ansSplit, ansLen);
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            	bw.write(findNumber(array, arrayAns));
            }
        }
    }
    
    public static void makeArray(int[] array, String[] split, int len) {
    	IntStream.range(0, len).forEach(i -> array[i] = Integer.parseInt(split[i]));
    }
}