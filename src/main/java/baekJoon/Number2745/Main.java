package baekJoon.Number2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int convert(String str, int number) {
        char[] charArray = str.toCharArray();
        int sum = 0;
        for (int i=charArray.length-1; i>=0; i-- ) {
            int tempChar = charArray[i] - '0';
            if (tempChar >= 10) {
            	int intConvert = (int)(charArray[i] - 'A' + 10);
            	sum += (intConvert*(Math.pow(number, charArray.length - i - 1)));
			} else {
				sum += (tempChar*(Math.pow(number, charArray.length - i - 1)));
			}
        }
        return sum;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(convert(input[0], Integer.parseInt(input[1])));
        br.close();
    }
}
