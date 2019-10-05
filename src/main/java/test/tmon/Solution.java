package test.tmon;

public class Solution {
	
	public static String maxLength(String str, String str1) {
		// 두 문자열에서 같은 문자 중 가장긴 문자를 리턴
		// 문자 하나씩 뽑은다음 indexOf로 비교
		// 같은 문자열 + 추가되는 문자열 -> indexOf = -1 이면 처음부터 시작하는게 아니라 찾았던 문자열 정보를 이용하면 최적화 가능
		String res = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i+1);
			sb.append(temp);
			System.out.println(sb.toString());
			int index = str1.indexOf(sb.toString());
			if (index > -1) {
				if (sb.length() > res.length()) {
					res = sb.toString();
				}
			} else if (sb.length() != 0) {
				String save = isExistMach(sb.substring(1), str1);
				sb.setLength(0);
				sb.append(save);
			} else {
				sb.setLength(0);
			}
		}
		return res;
	}
	
	public static String isExistMach(String str, String str1) {
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i);
			int index = str1.indexOf(temp);
			if (index > -1) {
				return temp;
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(maxLength( "abcdefg", "abcebcde" ));
//		StringBuilder sb = new StringBuilder("12345");
//		System.out.println(sb.substring(1,4));
	}
}
