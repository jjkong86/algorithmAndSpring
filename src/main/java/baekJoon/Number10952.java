package baekJoon;

import java.util.Scanner;

public class Nuber10952 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
	        while (true) {
	            String input = sc.nextLine();
	            if (input != null) {
	                String[] split = input.split(" ");
	                int a = Integer.parseInt(split[0]);
	                int b = Integer.parseInt(split[1]);
	                if (a + b != 0 && a < 10 && b < 10) {
	                    System.out.println(a+b);
	                } else {
	                	break;
	                }
	            }
	        }
	        sc.close();
		}
}
