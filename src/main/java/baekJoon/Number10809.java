package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number10809 {
	public static void main(String[] args) throws IOException {
		//입력된 단어에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치, 포함되지 않으면 -1
		//char - 97 하면 배열 인덱스가됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] charArray = input.toCharArray();
		int[] alphaArray = new int[26];
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (alphaArray[c - 97] == 0) {
				alphaArray[c - 97] = i == 0 ? 101 : i;
			}
		}
		StringJoiner sb = new StringJoiner(" ");
		for (int i : alphaArray) {
			sb.add(String.valueOf(i == 0 ? -1 : (i == 101 ? 0 : i)));
		}
		System.out.print(sb);
		br.close();
	}
}
