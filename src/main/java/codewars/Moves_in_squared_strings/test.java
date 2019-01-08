package codewars.Moves_in_squared_strings;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class test {
	public static String vertMirror(String strng) {
		// your code, 수평
		StringJoiner sj = new StringJoiner("\n");
		String[] split = strng.split("\n");
		for (int i = 0; i < split.length; i++) {
			char[] charArray = split[i].toCharArray();
			int len = charArray.length;
			for (int j = 0; j < len / 2; j++) {
				char temp = charArray[j];
				charArray[j] = charArray[len - j - 1];
				charArray[len - j - 1] = temp;
			}
			sj.add(new String(charArray));
		}
		return sj.toString();
	}
	
	public static String horMirror (String strng) {
        // your code, 수직
		String[] split = strng.split("\n");
		int len = split.length;
		for (int i = 0; i < len/2; i++) {
			String temp = split[i];
			split[i] = split[len- i - 1];
			split[len- i - 1] = temp;
		}
		return Arrays.asList(split).stream().map(i -> i.toString()).collect(Collectors.joining("\n"));
    }

	public static void main(String[] args) {
		String string1 = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
		String string2 = "lVHt\nJVhv\nCSbg\nyeCt";
		String vertMirror = vertMirror(string1);
		String horMirror = horMirror(string2);
		if (vertMirror.equals("QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw")) {
			System.out.println("success");
		}
		
		if (horMirror.equals("yeCt\nCSbg\nJVhv\nlVHt")) {
			System.out.println("success");
		}
		
		StringTokenizer st = new StringTokenizer(string2, "\n");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
			
	}

}
