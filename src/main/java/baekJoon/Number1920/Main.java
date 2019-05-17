package baekJoon.Number1920;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    public static void sort(int[] array, int left, int right) {
        //quick sort
        if (left > right) return;
        
        int partition = partition(array, left, right);
        sort(array, left, partition-1);
        sort(array, partition+1, right);
    }
    
    public static int partition(int[] array, int left, int right) {
        if (left > right) return left;
        int midIdx = (left + right)/2;
        int pivot = array[midIdx];
        
        while (right > left) {
            while (right > left && array[left] < pivot) left++;
            while (right > left && array[right] > pivot) right--;
            
            if (right > left) {
                swap(array, left, right);
            }
        }
        
        return left;
    }
    
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    public static String findNumber(int[] array, int[] ansArray) {
        StringBuilder sb = new StringBuilder();
        
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int arrayLen = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] array = new int[arrayLen];
            makeIntArray(split, array);
            int ansLen = Integer.parseInt(br.readLine());
            String[] ansSplit = br.readLine().split(" ");
            int[] ansArray = new int[ansLen];
            makeIntArray(ansSplit, ansArray);
        }
    }
    
    public static void makeIntArray(String[] strArray, int[] array) {
        IntStream.range(0, array.length)
            .forEach(i -> array[i] = Integer.parseInt(strArray[i]));
    }
}
