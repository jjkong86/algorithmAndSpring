package reetCodeAlgorithms.Longest_Palindromic_Substring;

class Solution1 {
    char[] chars;
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        chars = s.toCharArray();
        int len = chars.length;
        
        for (int i=0; i<len; i++) {
            for (int j = i+1; j<len; j++) {
                if (j - i + 1 > max && isPalindrome(i, j)) {
                    max = Math.max(max, (j - i + 1));
                    result = makeString(i, j);
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(int left, int right) {
        System.out.println(makeString(left, right));
        int end = right;
		for (int i = left; i <= right; i++) {
			if (chars[i] != chars[right-i])
                return false;
		}
		return true;
    }
    
    private String makeString(int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i=left; i<=right; i++) {
            sb.append(String.valueOf(chars[i]));
        }
        return sb.toString();
    }
}
