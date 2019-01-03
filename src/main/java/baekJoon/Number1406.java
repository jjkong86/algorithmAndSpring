package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		
		//L, D, B, P &
		int len = Integer.parseInt(br.readLine());
		int cursor = sb.length();
		int stringLen = cursor-1;
		String[] array = new String[len];
		for (int i = 0; i < len; i++) {
			array[i] = br.readLine();
		}
		
		for (int i = 0; i < len; i++) {
			String order = array[i];
			switch (order) {
			case "L":
				if (cursor > 0) {
					cursor--;
				}
				break;
			case "D":
				if (cursor < stringLen+1) {
					cursor++;
				}
				break;
			case "B":
				if (cursor > 0 && stringLen >=0) {
					sb.deleteCharAt(cursor-1);
					cursor--;
					stringLen--;
				}
				break;
			default:
				if (order.startsWith("P")) {
                    sb.insert(cursor, order.charAt(2));
                    cursor++;
                    stringLen++;
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
