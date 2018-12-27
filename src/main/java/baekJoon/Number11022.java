package baekJoon;

import java.util.Scanner;

public class Number11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(t);
		for (int i = 1; i <= t; i++) {
			int A = sc.nextInt();
			if (A < 0 || A > 10) {
				i--;
				continue;
			}
			int B = sc.nextInt();
			if (B < 0 || B > 10) {
				i--;
				continue;
			}
			System.out.println("Case #"+i+": "+A+" + "+B+" = "+(A+B));
		}
		sc.close();
		
	}
}
