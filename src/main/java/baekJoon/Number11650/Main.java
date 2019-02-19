package baekJoon.Number11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static String print(int[][] array) {
        //좌표정렬 -> x먼저 오름차순으로 정렬하고, x가 같을때 y를 다시 오름차순으로 정렬
        coordinateSort(array, 0, array[0].length-1);
        StringBuilder sb = new StringBuilder();
        return "";
    }
    
    public static void coordinateSort(int[][] array, int left, int right) {
        if (right > left) {
            int middle = middleValue(array, left, right);
            coordinateSort(array, left, middle-1);
            coordinateSort(array, middle+1, right);
        }
    }
    
    public static int middleValue(int[][] array, int left, int right) {
        //퀵 정렬로 하고, x의 좌표가 같을 때 로직 추가해야할듯
        while (right > left) {
            int middleValue = array[(left + right)/2][0];
            while (array[left][0] > middleValue && right > left) left++;
            while (array[right][0] < middleValue && right > left) right--;
            
            if (right > left) {
                int tempX = array[left][0];
                int tempY = array[left][1];
                array[left][0] = array[right][0];
                array[left][1] = array[right][1];
                array[right][0] = tempX;
                array[right][1] = tempY;
            }
        }
        return left;
    }
    
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[][] array = new int[5][2];
        
        for (int i=0; i<number; i++) {
            String[] split = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(split[0]);
            array[i][1] = Integer.parseInt(split[1]);
        }
        System.out.println(print(array));
        br.close();
    }
}
