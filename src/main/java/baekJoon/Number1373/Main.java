package baekJoon.Number1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String calculator(String str) {
        //1111 -> (1*1 + 2*1 + 2*2*1)*8square0 + (2*2*2*1)*8square1 
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();
        long base = 8;
        long target = 0;
        long sum = 0;
        for (int i=len-1; i>=0; i--) {
        	long num = convert(charArray[i], len - i - 1);
            target = (long) Math.pow(2, len - i - 1);
            if (target == base) {
            	sb.append(sum/(base/8));
                base *= 8;
                sum = num;
            } else {
                sum += num;
            }
            if (i == 0) {
				sb.append(sum/(base/8));
			}
        }
        return sb.reverse().toString();
    }
    public static long convert(char c, int index) {
        return (long) ((c - '0') * Math.pow(2, index));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculator(br.readLine()));
        br.close();
    }
}
