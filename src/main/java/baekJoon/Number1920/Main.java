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
            }
        }
        return left;
    }
    
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    public static String findNumber(int[] array, IndexAndNumber[] arrayAns) {
        StringBuilder sb = new StringBuilder();
//        sort(array, 0, array.length-1);
        Arrays.sort(array);
        Arrays.sort(arrayAns);
        
        int idx = 0;
        int[] retArray = new int[arrayAns.length];
        loop : for (int i = 0; i < retArray.length; i++) {
			if (arrayAns[i].number == array[idx]) {
				retArray[arrayAns[i].index] = 1;
			} else {
				while (arrayAns[i].number > array[idx]) {
					if (++idx >= array.length) break loop;
				}
				if (arrayAns[i].number == array[idx]) {
					retArray[arrayAns[i].index] = 1;
				}
			}
		}
        
        for (int i=0; i<arrayAns.length; i++) {
            sb.append(retArray[i]).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int len = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] array = new int[len];
            IntStream.range(0, len).forEach(i -> array[i] = Integer.parseInt(split[i]));
            
            int ansLen = Integer.parseInt(br.readLine());
            String[] ansSplit = br.readLine().split(" ");
            IndexAndNumber[] arrayAns = new IndexAndNumber[ansLen];
            IntStream.range(0, ansLen).forEach(i -> arrayAns[i] = new IndexAndNumber(i, Integer.parseInt(ansSplit[i])));
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            	bw.write(findNumber(array, arrayAns));
            }
        }
    }
}