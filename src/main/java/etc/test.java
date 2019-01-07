package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        System.out.println(input.length());
//        br.close();

        for (int i = 97; i < 122; i++) {
			int val = (i+1)%97;
			System.out.println((char)((val > 26 ? val%26 : val)+96));
//        	System.out.println((char)i);
		}
        System.out.println(Math.pow(10, 12)*9 > Integer.MAX_VALUE ? Math.pow(10, 12)*9 > Long.MAX_VALUE ? "Long < x" : "int < x < Long" : "int > x");
	}
}
