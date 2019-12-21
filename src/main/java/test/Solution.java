package test;

public class Solution {
	public int solution(String S) {
		// write your code in Java SE 8
		// 문자열 a,b가 3개 이상 반복되지 않아야함
		if (S.length() < 1)
			return 0;

		char[] chars = S.toCharArray();
		int dupleCount = 1;
		int subStringCount = 1;
		int result = 0;
		for (int i = 1; i < chars.length; i++) {
			char temp = chars[i];
			if (chars[i - 1] == temp) {
				if (dupleCount >= 2) {
					subStringCount = 2;
					continue;
				}
				dupleCount++;
			} else {
				dupleCount = 1;
			}
			subStringCount++;
			result = Math.max(result, subStringCount);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("baaabbabbb"));
		System.out.println(s.solution("babba"));
		System.out.println(s.solution("abaaaa"));
		System.out.println(s.solution("baaabbabbbabaabbabaaabbab"));
		System.out.println("bbabaabbabaa".length());
	}
}
