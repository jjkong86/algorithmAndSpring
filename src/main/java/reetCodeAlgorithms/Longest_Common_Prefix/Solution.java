package reetCodeAlgorithms.Longest_Common_Prefix;

import java.util.Iterator;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		//공통의 접두사
        //문자 하나씩 뽑아내고 -> 두번째 문자가 다르면 return
		//첫번째 문자와 두번째 문자를 full scan -> 없으면 ""return
		// 
		if(strs == null || strs.length == 0)    return "";
	    String ret = strs[0];
	    int i = 1;
	    while (strs.length > i) {
			while (strs[i].indexOf(ret) != 0) {
				ret = ret.substring(0, ret.length()-1);
			}
	    	i++;
		}
	    
		return ret;
    
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] strs = {"flower","",""};
		System.out.println(s.longestCommonPrefix(strs));
	}

}
