package baekJoon.Number11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    
	public static String coordinateSort(int[][] array) {
		//array[n][0] 의 값들로 정렬하고, 값이 같으면 array[n][1]의 값을 비교하여 정렬
        Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return 0;
			}
        	
		});
        
        return "";
    }
    
    public static void main(String[] args) throws IOException, NumberFormatException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	        int number = Integer.parseInt(br.readLine());
	        int[][] array = new int[5][2];
	        
	        for (int i=0; i<number; i++) {
	            String[] split = br.readLine().split(" ");
	            array[i][0] = Integer.parseInt(split[0]);
	            array[i][1] = Integer.parseInt(split[1]);
	        }
	        System.out.println(coordinateSort(array));
//        br.close();
        }
    }
}
