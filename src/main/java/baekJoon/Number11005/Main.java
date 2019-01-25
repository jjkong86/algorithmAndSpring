package baekJoon.Number11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static String convert(int[] array) {
        int b = array[1];
        int num = array[0];
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int quotient = num / b;
            int remainder = num - (b * quotient);
            if (remainder < 10) {
				sb.append(remainder);
			} else {
				sb.append((char)(remainder - 10 + 'A'));
			}
            num = quotient;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        System.out.println(convert(array));
        br.close();
    }
}
