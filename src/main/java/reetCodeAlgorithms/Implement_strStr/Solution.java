package reetCodeAlgorithms.Implement_strStr;

public class Solution {
	public int strStr(String haystack, String needle) {
		
		
		return haystack.indexOf(needle);
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String haystack = "hello";
		String needle = "he";
		
		System.out.println(s.strStr(haystack, needle));
		
	}

}
