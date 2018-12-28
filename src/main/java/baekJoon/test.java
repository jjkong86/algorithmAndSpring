package baekJoon;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for (int i=0; i<=len; i++) {
        	String input = sc.nextLine();
        	if (input.length() > 2) {
        		String[] split = input.split(",");
        		int a = Integer.parseInt(split[0]);
        		int b = Integer.parseInt(split[1]);
        		System.out.println(a+b);
        	}
        }
        sc.close();
	}

}
