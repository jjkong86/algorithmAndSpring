package baekJoon.Number1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String calculator(String str) {
        //1111 -> (1*1 + 2*1 + 2*2*1)*8square0 + (2*2*2*1)*8square1
    	//더해가면서 하려고 했지만.. long type 보다 커짐
    	//3자리씩 끊어서 8보다 작은수로 만들고 string으로 붙어야 할듯
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();
        if (str.equals("0") || str.equals(" ") || str.equals("")) {
			return "0";
		}
        
        long sum = 0;
        int index = 0;
        for (int i=len-1; i>=0; i--) {
        	//index%3 == 0 조건으로 하면 될듯
        	//10001111 -> 10,000,000 + 001,000 + 0,111 ->2 + 1 + 7
        	sum += convert(charArray[i], index);
        	if ((index + 1) % 3 == 0) {
				sb.append(sum);
				sum = 0;
				index = 0;
			} else {
				index++;
			}
        }
        if (sum != 0) {
			sb.append(sum);
		}
        return sb.reverse().toString();
    }
    public static int convert(char c, int index) {
        return (int) ((c - '0') * Math.pow(2, index));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculator(br.readLine()));
        br.close();
    }
}
