package codewars;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class Mumbling {

	private static void testing(String actual, String expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void test() {
		System.out.println("Fixed Tests accum");
		testing(Accumul.accum("ZpglnRxqenU"),
				"Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
		testing(Accumul.accum("NyffsGeyylB"),
				"N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb");
		testing(Accumul.accum("MjtkuBovqrU"),
				"M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu");
		testing(Accumul.accum("EvidjUnokmM"),
				"E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm");
		testing(Accumul.accum("HbideVbxncC"),
				"H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc");
	}

	public static class Accumul {

		public static String accum(String s) {
			char[] charArray = s.toCharArray();
//			String[] array = new String[s.length()];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < charArray.length; i++) {
//				StringBuilder sb = new StringBuilder();
				char c = charArray[i];
				for (int j = 0; j < i+1; j++) {
					sb.append(j == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
				}
				sb.append("-");
//				array[i] = sb.toString();
			}
			return sb.delete(sb.length()-1, sb.length()).toString();
//			return Arrays.stream(array).collect(Collectors.joining("-"));
		}

	}
}
