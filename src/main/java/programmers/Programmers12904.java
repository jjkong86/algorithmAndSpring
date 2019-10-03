package programmers;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

public class Programmers12904 {

	public int solution(String s) {
		if (s.length() == 1) return 1;
		int answer = 0;
		char[] chars = s.toCharArray();
		int len = chars.length;
//		System.out.println("String >> " + s);
		for (int i = 0; i < len-1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i + 1 > answer && chkPalindrome(chars, i, j)) {
//					System.out.println(new String(chars, i, j-i+1));
					answer = Math.max(answer, (j - i + 1));
				}
			}
		}
		
		if (s.length() > 1 && answer == 0) return 1; //길이가 1 이상이면서 팰린드롬이 아닌 문자케이스
		
		return answer;
	}

	public boolean chkPalindrome(char[] chars, int left, int right) {
		int end = right;
		for (int i = left; i <= right; i++) {
			if (chars[i] != chars[end--]) return false;
		}
		return true;
	}

	public static class TestClass {
		Programmers12904 p = new Programmers12904();

		@Test
		public void test1() {
			assertEquals(7, p.solution("abcdcba"));
		}

		@Test
		public void test2() {
			assertEquals(3, p.solution("abacde"));
		}

		@Test
		public void test3() {
			assertEquals(7, p.solution("aaaaaaa"));

			assertEquals(7, p.solution("abcdcba"));
			assertEquals(3, p.solution("abacde"));

			assertEquals(7, p.solution("aaaeeddddde"));
			assertEquals(1, p.solution("ajsfdkldsfjkl"));
			assertEquals(1, p.solution("abcdefg"));
			assertEquals(13, p.solution("abcbaedeabcba"));
			assertEquals(5, p.solution("adedaa"));
			assertEquals(5, p.solution("aadeda"));
			assertEquals(4, p.solution("aaaa"));

			assertEquals(5, p.solution("ababa"));
			assertThat(1, not(p.solution("bbaa")));
			assertThat(3, not(p.solution("baaba")));
			assertEquals(1, p.solution("a"));
			assertThat(1, not(p.solution("aa")));

			assertEquals(33, p.solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
			assertEquals(19, p.solution("bbbbaaaaaaaaaaaaaaaaaaaccccceeee"));
			assertEquals(21, p.solution("bbbbaaaaaaaaaaaaaaaaaaabcccceeee"));
		}
	}
}
