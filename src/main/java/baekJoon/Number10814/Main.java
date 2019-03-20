package baekJoon.Number10814;

import java.util.*;
import java.io.*;

public class Main {

	public static String ageSort(int[][] intArray, String[][] strArray) {
		
		Arrays.sort(intArray, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return (o1[1] - o2[1]);
				else return o1[0] - o2[0];
			}
		});
		return print(intArray, strArray);
	}
	
	public static String print(int[][] intArray, String[][] strArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intArray.length; i++) {
			sb.append(intArray[i][0]).append(" ").append(strArray[intArray[i][1]][0]).append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int number = Integer.parseInt(br.readLine());
			String[][] strArray = new String[number][2];
			int[][] intArray = new int[number][2];
			for (int i = 0; i < number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				intArray[i][0] = Integer.parseInt(st.nextToken());
				intArray[i][1] = i;
				strArray[i][0] = st.nextToken();
				strArray[i][1] = String.valueOf(i);
			}
			System.out.println(ageSort(intArray, strArray));
		}
	}
}
