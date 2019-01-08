package codewars.Moves_in_squared_strings;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Opstrings {
    
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
	
	public static String oper(Function<String, String> operator, String s) {
        // your code and complete ... before operator
        // oper(Opstrings::vertMirror, s)        
        return operator.apply(s);
        
    }
}
