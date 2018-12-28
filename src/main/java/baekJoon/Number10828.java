package baekJoon;

import java.util.Scanner;

public class Number10828 {
	static int top = -1;
	static int size = 10000;
	static int[] stack = new int[size];
	static boolean empty;
        
    public static void push(int value) {
        if (top <= size) {
            stack[++top] = value;
        } else {
            System.out.println("용량 초과");
        }
    }
    public static void size() {
        System.out.println(top+1);
    }
    
    public static void pop() {
        if (top >= 0) {
            System.out.println(stack[top]);
            stack[top--] = 0;
        } else {
            System.out.println("-1");
        }
    }
    
    public static void empty() {
        if (top < 0) {
        	System.out.println("1");
        } else {
        	System.out.println("0");
        }
    }
    
    public static void top() {
        if (top >= 0) {
            System.out.println(stack[top]);
        } else {
            System.out.println("-1");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for (int i=0; i<=len; i++) {
            String input = sc.nextLine();
            if (input.startsWith("push")) {
            	int value = Integer.parseInt(input.split(" ")[1]);
				push(value);
			} else if(input.startsWith("pop")) {
				pop();
			} else if(input.startsWith("size")) {
				size();
			} else if(input.startsWith("empty")) {
				empty();
			} else if(input.startsWith("top")) {
				top();
			}
        }
        sc.close();
    }
}
