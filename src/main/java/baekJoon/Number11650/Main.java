package baekJoon.Number11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    
	public static String coordinateSort(int[][] array) {
		//array[n][0] 의 값들로 정렬하고, 값이 같으면 array[n][1]의 값을 비교하여 정렬
        Arrays.sort(array, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				System.out.println(o1[0]+" "+o1[1]+":::"+o2[0]+" "+o2[1]);
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
        return print(array);
    }
	public static String print(int[][] array) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i< array.length; i++) {
			sb.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
		}
		return sb.toString();
	}
    
    public static void main(String[] args) throws IOException, NumberFormatException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	        int number = Integer.parseInt(br.readLine());
	        int[][] array = new int[number][2];
	        for (int i=0; i<number; i++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	array[i][0] = Integer.parseInt(st.nextToken());
	        	array[i][1] = Integer.parseInt(st.nextToken());
	        }
	        System.out.println(coordinateSort(array));
        }
    }
}
