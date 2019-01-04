package codewars.Jaden_Casing_Strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class JadenCaseTest {

	JadenCase jadenCase = new JadenCase();

	@Test
	public void test() {
		assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue",
				jadenCase.toJadenCase2("most trees are blue"));
	}

	@Test
	public void testNullArg() {
		assertNull("Must return null when the arg is null", jadenCase.toJadenCase(null));
	}

	@Test
	public void testEmptyArg() {
		assertNull("Must return null when the arg is empty string", jadenCase.toJadenCase(""));
	}

	public class JadenCase {

		public String toJadenCase(String p) {
			if (p == null || p.equals("")) {
				return null;
			}
			String[] split = p.split(" ");
			for (int i = 0; i < split.length; i++) {
				String token = split[i];
				char s = Character.toUpperCase(token.charAt(0));
				split[i] = token.replace(token.charAt(0), s);
			}

			return Arrays.asList(split).stream().collect(Collectors.joining(" "));
		}

		public String toJadenCase1(String phrase) {
			if (phrase == null || phrase.equals(""))
				return null;

			char[] array = phrase.toCharArray();

			for (int x = 0; x < array.length; x++) {
				if (x == 0 || array[x - 1] == ' ') {
					array[x] = Character.toUpperCase(array[x]);
				}
			}

			return new String(array);
		}

		public String toJadenCase2(String phrase) {
			if (null == phrase || phrase.length() == 0) {
				return null;
			}
			return Arrays.stream(phrase.split(" "))
					.map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
					.collect(Collectors.joining(" "));
		}
	}
}
