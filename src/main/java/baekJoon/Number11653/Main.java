package baekJoon.Number11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String factorizationPrimeFactor(String str) {
		try {
			
			System.out.println(str.charAt(100));
		} catch (Exception e) {
			System.out.println("안됨");
		}
		return "";
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorizationPrimeFactor(br.readLine()));
		br.close();
	}
}