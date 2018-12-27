package baekJoon;

import java.util.Scanner;

public class Number11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for (int i = 0; i <= input.length(); i+=10) {
			int index = i + 10;
			index = index > input.length() ? input.length() : index;
			System.out.println(input.substring(i, index));
		}
		sc.close();
	}
}
