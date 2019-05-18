package baekJoon.Number1920;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
	public static class IndexAndNumber implements Comparable<IndexAndNumber>{
		int index;
		int number;
		
		public IndexAndNumber(int i, int n) {
			this.index = i;
			this.number = n;
		}
		
		@Override
		public int compareTo(IndexAndNumber o) {
			return Integer.compare(this.number, o.number);
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.number);
		}
	}
	
    public static void sort(int[] array, int left, int right) {
        //quick sort
        if (left > right) return;
        
        int partition = partition(array, left, right);
        sort(array, left, partition-1);
        sort(array, partition+1, right);
    }
    
    public static int partition(int[] array, int left, int right) {
        int midIdx = (left + right)/2;
        int pivot = array[midIdx];
        
        while (right > left) {
            while (right > left && array[left] < pivot) left++;
            while (right > left && array[right] > pivot) right--;
            
            if (right > left) {
                swap(array, left, right);
                System.out.println(Arrays.toString(array));
            }
        }
        return left;
    }
    
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    public static String findNumber(int[] array, IndexAndNumber[] ansArray) {
        StringBuilder sb = new StringBuilder();
        sort(array, 0, array.length-1);
//        sort(ansArray, 0, ansArray.length-1);
        Arrays.sort(ansArray);
        System.out.println("array > "+Arrays.toString(array));
        System.out.println("ansArray > "+Arrays.toString(ansArray));
        
        int idx = 0;
        int idxAns = 0;
        int[] retArray = new int[ansArray.length];
        loop : while (idxAns <= ansArray.length) {
            if (array[idx] == ansArray[idxAns].number) {
            	retArray[idxAns++] = 1;
            } else {
                if (idx <= array.length) break loop;
                while (idx <= array.length) {
                    if (array[idx++] == array[idxAns]) {
                        idx--;
                        break;
                    }
                }
            }
        }
        
        for (int i=idxAns; i<ansArray.length; i++) {
        	retArray[i] = 0;
            sb.append("0").append("\n");
        }
        
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
            IndexAndNumber[] ansArray = new IndexAndNumber[ansLen];
//            makeIntArray(ansSplit, ansArray);
            for (int i = 0; i < ansLen; i++) {
				ansArray[i] = new IndexAndNumber(i, Integer.parseInt(ansSplit[i]));
			}
            System.out.println(findNumber(array, ansArray));
        }
    }
    
    public static void makeIntArray(String[] strArray, int[] array) {
        IntStream.range(0, array.length).forEach(i -> array[i] = Integer.parseInt(strArray[i]));
    }
}
