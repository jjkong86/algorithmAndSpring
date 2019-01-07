package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number10820 {
	private final static int lower = 0;
	private final static int upper = 1;
	private final static int num = 2;
	private final static int gap = 3;
	public static void main(String[] args) throws IOException {
		//숫자는 48 ~ 57
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringJoiner sj = new StringJoiner("\n");
		String stringInput;
		while ((stringInput = br.readLine()) != null) {
			char[] input = stringInput.toCharArray();
			int[] seperation = new int[4];
			for (char c : input) {
				if (Character.isUpperCase(c)) {
					seperation[upper] = seperation[upper] +1;
				} else if (Character.isLowerCase(c)) {
					seperation[lower] = seperation[lower] +1;
				} else if (Character.isDigit(c)) { //c >= 48 && c <= 57
					seperation[num] = seperation[num] +1;
				} else if (c == ' ') {
					seperation[gap] = seperation[gap] +1;
				}
			}
			StringJoiner subSj = new StringJoiner(" ");
			for (int i : seperation) {
				subSj.add(String.valueOf(i));
			}
			sj.add(subSj.toString());
		}
		br.close();
		System.out.println(sj);
	}
}
