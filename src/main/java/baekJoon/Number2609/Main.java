package baekJoon.Number2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static String calNumber(int num1, int num2) {
        //최대공약수 -> 두 정수의 약수 중 최대값, 
        //최소공배수 -> 두 정수가 공통적으로 가지는 배수 중 가장 작은 값
        //a ,b -> a * b/최대공약수
        StringBuilder sb = new StringBuilder();
        int minMax = minMax(num1, num2);
        sb.append(minMax + "\n");
        sb.append((num1 * num2) / minMax);
        return sb.toString();
    }
    public static int minMax(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        } else {
            return minMax(num2, num1%num2);
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        if (array[0] > array[1]) {
            System.out.println(calNumber(array[0], array[1]));
        } else {
            System.out.println(calNumber(array[1], array[0]));
        }
        br.close();
    }
    
}
