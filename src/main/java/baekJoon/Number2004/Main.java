package baekJoon.Number2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    
    public static int CombinationFindZero(int a, int b) {
        // nPr = n! / (n-r)! -> ex) 5P3 = 5! / 2!
        // nCr = nPr / r! = n! / (n-r)! * r! -> 5C3 = 5P3 / 3! = 5! / 2! * 3!
        // 0의 개수 -> Math.min(number2Count, number5Count) /  Math.max(number2Count, number5Count)
		// 2의 배수, 5의 배수를 각각 구하면??
    	
        return Math.min(calculate(a, 2) - (calculate(b, 2) + calculate(a-b, 2)), calculate(a, 5) - (calculate(b, 5) + calculate(a-b, 5)));
    }
    
    public static int calculate(int num, int type) {
    	int ret = 0;
    	for (long i = type; i <= num; i*=type) {
    		ret += num/i;
		}
    	return ret;
    }
    
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        System.out.println(CombinationFindZero(array[0], array[1]));
        br.close();
    }
}