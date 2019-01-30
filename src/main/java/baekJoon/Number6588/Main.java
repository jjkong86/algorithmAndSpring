package baekJoon.Number6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String findPrimeSum(int[] array, int max, int count) {
		int[] dp = new int[max + 1];
        int[] prime = new int[max + 1];
		for (int i=3; i<max+1; i=i+2) {
            dp[i] = 1;
        }
        int index = 0;
		for (int i = 2; i<= max; i++) {
			if (dp[i] != 0) {
				prime[index++] = i;
				for (int j = i * 2; j <= max; j = j + i) {
					dp[j] = 0;
				}
			}
		}
        // 2,3,5,7,11,13,17 -> 19?
        // 2,17 -> a,b저장, b-a=15 -> 
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSave = new StringBuilder();
        for (int i=0; i<count; i++) {
            int temp = array[i];
            for (int j=0; j<index; j++) {
                int a = prime[j];
                int b = temp - a;
                if (b - a < 0) break;
                if (dp[b] == 1) {
                    tempSave.append(temp).append(" = ").append(a).append(" + ").append(b);
                    break;
                }
            }
            if (tempSave.length() < 1) {
                sb.append("Goldbach's conjecture is wrong." + "\n");
            } else {
                sb.append(tempSave + "\n");
            }
            tempSave.setLength(0);
        }
        
		return sb.toString();
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;
        int count = 0;
        int max = 0;
        int[] array = new int[100000];
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            array[count++] = num;
            if (num > max) {
                max = num;
            }
        }
        System.out.println(findPrimeSum(array, max, count));
		br.close();
	}
}