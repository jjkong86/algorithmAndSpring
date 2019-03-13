package baekJoon.Number1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int findAnswer(int[] array) {
        int len = array.length;
        boolean flag = false;
        for (int i=0; i<len; i++) {
        	flag = false;
            for (int j=0; j<len; j++) {
                if (array[j] > array[j+1]) {
                	flag = true;
                    array = swap(array, j, j+1);
                }
            }
            if (flag == false) {
                
                break;
            }
        }
        
        
        
        return 0;
    }
    
    public static int[] swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return array;
    }
    
    
    public static void main(String[] args) throws IOException, NumberFormatException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(br.readLine());
            int[] array = new int[number];
            for (int i=0; i<number; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(findAnswer(array));
        }
    }
}
