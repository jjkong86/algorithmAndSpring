package algorithms.Longest_Palindromic_Substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public String longestPalindrome(String s) {
		/*
		회문이 최대 개수인 string 리턴
		1.주어진 stirng s에서 하나씩 뽑아내어 stirng saveStr에 저장
			- saveStr이 회문인지 검증
			- 회문 검증은 어떻게? : saveStr의 (0+n)과 (saveStr.length() - n)이 같아야함
			 
		*/
		String saveStr = "";
		int savaStrL = saveStr.length();
		String maxStr = "";
		int sLen = s.length();
		List<String> sList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			sList.add(s.substring(i, i+1));
		}
		List<String> saveList = new ArrayList<>();
		List<String> maxList = new ArrayList<>();
		Boolean flag = false;
		
		for (int i = 0; i < sList.size(); i++) {
			for (int j = i+1; j < sList.size(); j++) {
				if(sList.get(i).equals(sList.get(j))) {
					saveList = sList.subList(i, j+1);
					for (int j2 = 0; j2 < saveList.size(); j2++) {
						int count = 0;
						if (saveList.get(j2).equals(saveList.get(saveList.size()-1-j2))&& (int)saveList.size()/2 >= j2) {
							count++;
							flag = (j2 == saveList.size()-1) && (int)saveList.size()/2 == count ? true : false;
						}
					}
					maxList = flag == true ? saveList : maxList; 
					
				}
			}
		}
		for (int i = 0; i < maxList.size(); i++) {
			maxStr += maxList.get(i);
		}
		
		
		return maxStr;
	}
	
	public Boolean validation(String s) {
		
		return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String input = "babbabd";
		String result = s.longestPalindrome(input);
		System.out.println(result);
	}
}
