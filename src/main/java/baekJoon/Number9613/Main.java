package baekJoon.Number9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    
	public static long calNumber(int[] array) {
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				sum += minMax(array[j], array[i]);
			}
		}
		return sum;
	}
	
    public static int minMax(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        } else {
            return minMax(num2, num1%num2);
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
        	String[] split = br.readLine().split(" ");
        	int[] array = new int[split.length-1];
        	IntStream.range(1, split.length).map(j -> array[j-1] = Integer.parseInt(split[j])).toArray();
        	Arrays.sort(split);
        	sb.append(calNumber(array) + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
