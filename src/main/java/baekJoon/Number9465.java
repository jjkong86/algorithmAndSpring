package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Number9465 {

	public static int maxScore(int[][] str, int cardNum) {
		//최대값 위주로 때면 될까?
		
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		StringJoiner sj = new StringJoiner("\n");
		for (int i = 0; i < len; i++) {
			int cardNum = Integer.parseInt(br.readLine());
			int[][] scoreBundle = new int[2][cardNum];
			int max = 0;
			for (int j = 0; j < scoreBundle.length; j++) {
				String[] split = br.readLine().split(" ");
				for (int k = 0; k < split.length; k++) {
					scoreBundle[j][k] = Integer.parseInt(split[k]);
				}
				max = Arrays.stream(scoreBundle[j]).max().getAsInt();
				// Stream.of(scoreBundle[j]).max(Comparator.comparing(Integer::valueOf)).get(); string 비교
				System.out.println(max);
			}
			sj.add(String.valueOf(maxScore(scoreBundle, cardNum)));
		}
		br.close();
	}
}
