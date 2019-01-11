package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Number9465 {

	public static int maxScore(String[][] str, int cardNum) {
		//최대값 위주로 때면 될까?
		
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < len; i++) {
			int cardNum = Integer.parseInt(br.readLine());
			String[][] scoreBundle = new String[2][cardNum];
			for (int j = 0; j < scoreBundle.length; j++) {
				String[] split = br.readLine().split(" ");
				for (int k = 0; k < split.length; k++) {
					scoreBundle[j][k] = split[k];
				}
				Optional<String> max = Stream.of(scoreBundle[j]).max(Comparator.comparing(Integer::valueOf));
			}
			sj.add(String.valueOf(maxScore(scoreBundle, cardNum)));
		}
		br.close();
	}
}
