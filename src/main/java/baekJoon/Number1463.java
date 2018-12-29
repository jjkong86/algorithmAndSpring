package baekJoon;

import java.util.Scanner;

public class Number1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(makeOne(input));
        sc.close();
    }
    public static int makeOne(int value) {
    	int[] array = new int[value+1];
    	array[0] = array[1] = 0;
    	 for (int i = 2; i <= value; i++) {
			array[i] = array[i-1]+1;
			if (i%2 == 0) {
				array[i] = Math.min(array[i], array[i/2]+1);
			}
			if (i%3 == 0) {
				array[i] = Math.min(array[i], array[i/3]+1);
			}
		}
        return array[value];
    }
}
