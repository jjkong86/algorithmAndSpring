package test.unitas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test8 {
	
	public static int findMinPrice(int[][] array) {
		int len = array.length;
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str+=i+1;
		}
		int minprice = 0;
		for (int i = 0; i < array.length; i++) {
			findPrice(array, str);
		}
		
		
		return 0;
	}
	
	public static int findPrice(int[][] array, String str) {
		int minPrice = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
		}
		
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num = Integer.parseInt(br.readLine());
			int[][] array = new int[num][num];
			for (int i = 0; i < num; i++) {
				String[] split = br.readLine().split(" ");
				for (int j = 0; j < split.length; j++) {
					array[i][j] = Integer.parseInt(split[j]);
				}
			}
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
				bw.write(findMinPrice(array));
			}
		}
	}
}
