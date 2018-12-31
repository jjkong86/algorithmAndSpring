package baekJoon;

import java.util.Scanner;

public class Number10430 {
	public static void main(String[] args) {
	    //첫째 줄에 (A+B)%C, 둘째 줄에 (A%C + B%C)%C, 셋째 줄에 (A×B)%C, 넷째 줄에 (A%C × B%C)%C를 출력한다.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.length() > 4) {
            String[] split = input.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            System.out.println((a+b)%c);
            System.out.println((a%c+b%c)%c);
            System.out.println((a*b)%c);
            System.out.println((a%c*b%c)%c);
        }
        sc.close();
    }
}
