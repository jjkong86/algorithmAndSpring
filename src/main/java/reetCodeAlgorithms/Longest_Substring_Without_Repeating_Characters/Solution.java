package algorithms.Longest_Substring_Without_Repeating_Characters;

public class Solution {
	
	public static int lengthOfLongestSubstring(String s) {
		/*
		 * 문제 : 주어진 문자열에 반복되지 않는 최대 문자열 개수
		1. 주어진 문자열을 저장 - 이때 저장은 저장된 문자열에 주어진 n번째 문자열이 같은가를 비교 후 저장
		2. 반복 되는 문자열 발견 - 최대 개수 저장 후 초기화
		3. String a = "abcdeef"
			- String b = "abcde" -> "abcdee" -> "e" -> "ef" 
		 */
		if("".equals(s) || s == null){
            return 0;
        }
		String saveStr = s.substring(0,1);
        int sLen = s.length();
        int maxCount = 0;
        String maxStr = "";
        for(int i=1; i<sLen; i++) {
            String tempStr = s.substring(i, i+1);
            if(saveStr.contains(tempStr)) {
            	if(maxCount < saveStr.length()) {
            		maxStr = saveStr;
            	}
            	saveStr = saveStr.substring(saveStr.indexOf(tempStr)+1, saveStr.length());
            }
            saveStr += tempStr;
        }
        if(maxCount == 0) {
        	maxCount = saveStr.length();
        	maxStr = saveStr;
        } else {
        	if (maxCount < saveStr.length()) {
            	maxCount = saveStr.length();
            	maxStr = saveStr;
			}
        }
        System.out.println(maxStr + "::"+maxCount);
		return maxCount;
    }

	public static void main(String[] args) {
		String s = "abcdabc";
		int max = lengthOfLongestSubstring(s);
		System.out.println(max);
		
	}

}
