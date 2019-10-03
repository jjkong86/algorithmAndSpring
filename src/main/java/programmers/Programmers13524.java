package programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Programmers13524 {
	public int solution(String s) {
		if (s.length() == 1)
			return 1;
		char[] chars = s.toCharArray();
		int len = chars.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = len - 1; j > i; j--) {
				if (res > j - i + 1)
					break;
				int count = chkPalindrome(i, j, chars);
				if (count != 0 && count > res)
					res = count;
			}
		}

		return res;
	}

	private int chkPalindrome(int left, int right, char[] chars) {
		int end = right;
		for (int i = left; i < right; i++) {
			if (chars[i] != chars[end--]) {
				return 0;
			}
		}
		return right - left + 1;
	}
	
	public static class TestClass {
		Programmers13524 p = new Programmers13524();
		@Test
		public void test1() {
			assertThat(1, is(p.solution("abc")));
		}
		
	}
}
