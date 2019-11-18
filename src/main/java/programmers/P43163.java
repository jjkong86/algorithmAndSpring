package programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class P43163 {
	public int solution(String begin, String target, String[] words) {
		int answer = minConversion(begin, target, words, 0, new boolean[words.length]);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	private int minConversion(String find, String target, String[] words, int count, boolean[] useChk) {
		if (find.equals(target)) {
			return count;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (useChk[i] == false && isEq(find, words[i])) {
				boolean[] copy = Arrays.copyOf(useChk, words.length);
				copy[i] = true;
				result = Math.min(result, minConversion(words[i], target, words, count + 1, copy));
			}
		}
		return result;
	}

	private boolean isEq(String find, String target) {
		int len = find.length(), count = 0;
		for (int i = 0; i < find.length(); i++) {
			if (find.charAt(i) == target.charAt(i))
				count++;
		}
		return len - 1 == count;
	}

	public static class TestClass {
		P43163 p = new P43163();

		@Test
		public void test1() {
			assertThat(4, is(p.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" })));
		}

		@Test
		public void test2() {
			assertThat(0, is(p.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log" })));
		}

	}
}
