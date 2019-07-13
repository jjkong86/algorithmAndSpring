package test;

public class Solution {
	
	public static String maxLength(String str, String str1) {
		String res = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i+1);
			sb.append(temp);
			int index = str1.indexOf(sb.toString());
			if (index > -1) {
				if (sb.length() > res.length()) {
					res = sb.toString();
				}
			} else {
				sb.setLength(0);
				sb.append(temp);
			}
		}
		
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(maxLength( "penpineapple", "applepen" ));
	}
}
