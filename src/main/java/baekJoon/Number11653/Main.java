package baekJoon.Number11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String factorizationPrimeFactor(String str) {
		int num = Integer.parseInt(str);
		StringBuilder sb = new StringBuilder();
		
		while (num != 0) {
			
		}
		
		return sb.toString();
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorizationPrimeFactor(br.readLine()));
		br.close();
	}
}