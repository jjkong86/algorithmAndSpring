package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number9465 {

	public static int maxScore(String[] str, int cardNum) {
		
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < len; i++) {
			String[] scoreBundle = new String[2];
			int cardNum = Integer.parseInt(br.readLine());
			for (int j = 0; j < scoreBundle.length; j++) {
				scoreBundle[j] = br.readLine();
				System.out.println(scoreBundle[j]);
			}
			sj.add(String.valueOf(maxScore(scoreBundle, cardNum)));
		}
		br.close();
	}
}
