package baekJoon.Number11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String factorizationPrimeFactor(String str) {
		if (str.equals("")) {
			return null;
		}
		int num = Integer.parseInt(str);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i*i <= num; i++) {
			while (num % i == 0) {
				sb.append(i + "\n");
				num = num / i;
			}
		}
		if (num > 1) sb.append(num + "\n");
		return sb.toString();
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorizationPrimeFactor(br.readLine()));
		br.close();
	}
}