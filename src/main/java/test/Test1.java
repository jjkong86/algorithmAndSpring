package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {
	
	public static String findLastEat(String[] array) {
		StringBuilder sb = new StringBuilder();
		int[] ans = new int[] {1,7,6,1,9};
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(" ");
			int num1 = Integer.parseInt(temp[0]);
			int num2 = Integer.parseInt(temp[1]);
			
			int amount = num1^num2;
//			System.out.println(num1+"::"+amount+"::"+amount%num1 + ":::"+ans[i]);
			System.out.println(amount%num1+1 + ":::"+amount);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num = Integer.parseInt(br.readLine());
			String[] array = new String[num];
			for (int i = 0; i < num; i++) {
				array[i] = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
				bw.write(findLastEat(array));
			}
		}
	}
}
