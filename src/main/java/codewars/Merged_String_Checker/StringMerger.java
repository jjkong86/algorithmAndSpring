package codewars.Merged_String_Checker;

import java.util.*;
import java.util.stream.*;

public class StringMerger {
	/*
	 * 주어진 문자열s를 part1과 part2를 조합하여 만들어 지는가? s를 기준으로 반복문을 돌면서 part1과 part2의 문자열을 꺼냄
	 */
	public static boolean isMerge(String s, String part1, String part2) {
		if(s.length() != part1.length() + part2.length()) return false;
	    if(s.length() == 0) return true;
	    return (part1.length() > 0 && part1.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2)) ||
	            (part2.length() > 0 && part2.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1, part2.substring(1)));
	}

	public static class Pair {
		int index;
		String str;

		public Pair(int index, String str) {
			this.index = index;
			this.str = str;
		}
	}
}
