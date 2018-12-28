package baekJoon;

import java.util.Scanner;

public class Number1463 {

	//모든 숫자를 1로 만들기, 횟수의 최소값으로
    // 9, 6, 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
//        int num = sc.nextInt();
        System.out.println(makeOne(input, 0));
        sc.close();
    }
    public static int makeOne(double value, int count) {
    	if (value == 0)return 0;
		
    	if (value == 1) return count;
        
        if(value % 3 == 0 || (value -1) % 3 == 0) {
        	if ((value -1) % 3 == 0) {
        		System.out.println("-뺌 ->"+(value-1) + "::" + (count+1));
        		value += -1;
        		count += 1;
        	}
        	System.out.println("3으로 나눔 ->"+value/3 + "::" + (count+1));
            count = makeOne(value/3, count+1);
        } else if (value % 2 == 0) {
        	System.out.println("2로 나눔 ->"+value/2 +"::"+ (count+1));
        	count = makeOne(value/2, count+1);
        } else if (value % 3 != 0 && value % 2 != 0) {
        	System.out.println("-뺌 ->"+(value-1) + "::" + (count+1));
        	count = makeOne(value-1, count+1);
        }
        return count;
    }
}
