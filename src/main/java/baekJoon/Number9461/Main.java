package baekJoon.Number9461;

import java.util.*;
import java.io.*;

public class Main {
    
    public static String PadovanSequence(int[] array, int maxNum) {
//        int maxNum = IntStream.of(array).max().getAsInt();
        long[] dp = new long[maxNum+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i=3; i<=maxNum; i++) {
        	dp[i] = dp[i-2] + dp[i-3];
        }
        StringJoiner sj = new StringJoiner("\n");
        for (int i=0; i<array.length; i++) {
            sj.add(String.valueOf(dp[array[i]]));
        }
        
        return sj.toString();
    }
    
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(br.readLine());
            int[] array = new int[len];
            int max = 0;
            for (int i=0; i<len; i++) {
                array[i] = Integer.parseInt(br.readLine());
                if (array[i] > max) {
					max = array[i];
				}
            }
            System.out.println(PadovanSequence(array, max));
            br.close();    
        } catch(Exception e) {
            
        }
    }
}

