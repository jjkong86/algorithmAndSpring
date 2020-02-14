package test.npay;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
	//문자열에서 반복되지 않는 문자로 분리 했을 때 분리된 문자의 개수
	public int solution(String S) {
		if (S == null || S.length() == 0)
			return 0;

		int result = 1;
		Set<Character> set = new HashSet<>();
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length - 1; i++) {
			set.add(chars[i]);
			if (set.contains(chars[i + 1])) {
				result++;
//				System.out.println(set.toString());
				set.clear();
			}
		}

		return result;
	}

	public boolean isContains(Set<Character> set, char c) {
		return set.contains(c);
	}

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(s.solution("abacdec") == 3);
		System.out.println(s.solution("abacdecc") == 4);
		System.out.println(s.solution("dddd") == 4);
		System.out.println(s.solution("world") == 1);
		System.out.println(s.solution("cycle") == 2);
		System.out.println(s.solution("c") == 1);
		System.out.println(s.solution("") == 0);
	}
}
