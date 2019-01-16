package codewars.Consecutive_strings;

public class LongestConsec {
	public static String longestConsec(String[] strarr, int k) {
		// k = 문자열 개수
		// 처음으로 연속적인, 가장 긴 문자열을 반환
		// 문자열 String[] strarr에서 int k만큼 연속된(더한) 문자 str 중 가장 길고 먼저 시작된 문자를 리턴
		if (strarr.length == 0 || k > strarr.length || k < 1) {
			return "";
		}
		String maxString = "";
		outerloop: for (int i = 0; i < strarr.length; i++) {
			StringBuilder sb = new StringBuilder();
			if (i + k > strarr.length) {
				break outerloop;
			}
			for (int j = 0; j < k; j++) {
				sb.append(strarr[i + j]);
			}
			if (sb.length() > maxString.length()) {
				maxString = sb.toString();
			}
		}
		return maxString;
	}
}
