package algorithms.Longest_Substring_Without_Repeating_Characters;

public class Solution {
	
	public int lengthOfLongestSubstring(String s) {
        String saveStr = "";
        int sLen = s.length();
        
        for(int i=0; i<sLen; i++) {
        	
        }
		return sLen;
    }

	public static void main(String[] args) {
		String s = "abcdabcbbabcdef";
		String saveStr = s.substring(0,1);
        int sLen = s.length();
        int maxCount = 0;
        Boolean flag = false;
        String renStr = "";
        for(int i=1; i<sLen; i++) {
            String tempStr = s.substring(i, i+1);
            for(int j=0; j<saveStr.length(); j++) {
                if(tempStr.equals(saveStr.substring(j, j+1))) {
                    flag = true;                    
                }
            }
            if(!flag) {
                saveStr += tempStr;
            } else {
            	if(renStr.length() < saveStr.length()) {
            		renStr = saveStr;
            	}
                saveStr.substring(1);
            }
            
        }
        System.out.println(renStr);
	}

}
