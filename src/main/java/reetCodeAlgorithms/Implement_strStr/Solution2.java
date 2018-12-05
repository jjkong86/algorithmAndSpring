package reetCodeAlgorithms.Implement_strStr;

public class Solution2 {
	public int strStr(String haystack, String needle) {
		int h = haystack.length();
		int n = needle.length();
		if(n == 0) return 0;
		if(n > h) return -1;
		//5, 2
		for (int i = 0; i < haystack.length()-n+1; i++) {
			String saveStr = haystack.substring(i, n+i);
			
			if (saveStr.equals(needle)) {
				return i;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String haystack = "a";
		String needle = "a";
		
		System.out.println(s.strStr(haystack, needle));
		
	}

}
