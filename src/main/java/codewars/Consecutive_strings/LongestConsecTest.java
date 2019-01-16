package codewars.Consecutive_strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestConsecTest {

	private static void testing(String actual, String expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void test() {
		System.out.println("longestConsec Fixed Tests");
		testing(LongestConsec.longestConsec(
				new String[] { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" }, 2),
				"abigailtheta"); // [4, 7, 5, 4, 4, 3, 5, 7]
		testing(LongestConsec.longestConsec(
				new String[] { "ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh" },
				1), "oocccffuucccjjjkkkjyyyeehh"); // [11, 8, 11, 10, 26]
		testing(LongestConsec.longestConsec(new String[] {}, 3), "");
		testing(LongestConsec.longestConsec(new String[] { "itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv",
				"vweqilsfytihvrzlaodfixoyxvyuyvgpck" }, 2),
				"wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
		testing(LongestConsec.longestConsec(new String[] { "wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu" }, 2),
				"wlwsasphmxxowiaxujylentrklctozmymu"); // [11, 23, 10]
		testing(LongestConsec.longestConsec(new String[] { "zone", "abigail", "theta", "form", "libe", "zas" }, -2),
				"");
		testing(LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 3),
				"ixoyx3452zzzzzzzzzzzz"); // [2, 5, 5, 4, 12]
		testing(LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 15), "");
		testing(LongestConsec.longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" }, 0), "");
	}
}
