package programmers;


import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

class Programmers42576 {
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		int pLen = participant.length;
		int cLen = completion.length;
		for (int i = 0; i < pLen; i++) {
			String pStr = participant[i];
			if (i >= cLen)
				return pStr;
			String sStr = completion[i];
			if (!pStr.equals(sStr)) {
				return pStr;
			}

		}
		return "";
	}
	public static class testClass {
		@Test
		public void test() {
			assertEquals("leo",	solution(new String[]{ "leo", "kiki", "eden" }, new String[]{ "eden", "kiki" }));
			assertEquals("vinko",	solution(new String[]{ "marina", "josipa", "nikola", "vinko", "filipa" }, new String[]{ "josipa", "filipa", "marina", "nikola" }));
		}
	}
}
