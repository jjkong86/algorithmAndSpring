package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2751 {
	public static void main(String[] args) {
		int len;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
			len = Integer.parseInt(br.readLine());
			int[] list = new int[len];
	        for (int i=0; i<len; i++) {
	            list[i] = Integer.parseInt(br.readLine());
	        }
	        list = heapSort(list, len-1);
            
            for (int i = list.length-1; i >= 0 ; i--) {
			    int temp = list[i];
			    list[i] = list[0];
			    list[0] = temp;
			    heapSort(list, i);
		    }
            
	        StringBuilder sb = new StringBuilder();
	        for (int i=0; i<len; i++) {
	        	sb.append(list[i]+"\n");
	        }
	        System.out.println(sb);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
        
	}
	private static int[] heapSort(int[] array, int len) {
		
		for (int i = 1; i < len; i++) {
			int child = i;
			
			while (child > 0) {
				int parent = child/2;
				if (array[child] > array[parent]) {
					int temp = array[parent];
					array[parent] = array[child];
					array[child] = temp;
				}
				child = parent;
			}
		}
		return array;
	}
}
