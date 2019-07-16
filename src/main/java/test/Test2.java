package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
	
	public static String makeQueue(int[] array) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		list.add(1);
		for (int i = 1; i < array.length; i++) {
			list.add(array[i], i+1);
		}
		
		for (int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i) + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			int[] array = new int[num];
			for (int i = 0; i < num; i++) {
				array[i] = Integer.parseInt(split[i]);
			}
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
				bw.write(makeQueue(array));
			}
		}
	}
}
