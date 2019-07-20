package test;

public class Solution {
	
	public static String maxLength(String str, String str1) {
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
			} else if (sb.length() != 0){
				String save = sb.substring(1, sb.length()-1);
				sb.setLength(0);
				sb.append(save);
				i = i-1;
			} 
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(maxLength( "abcde", "abcbcde" ));
//		StringBuilder sb = new StringBuilder("12345");
//		System.out.println(sb.substring(1,4));
	}
}
