package reetCodeAlgorithms.Letter_Combinations_of_a_Phone_Number;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public List<String> letterCombinations(String digits) {
		// Input: "23"
		// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
		// mapping[2].length() * mapping[2].length() = 9
		
		
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String digits = "23";
		System.out.println(s.letterCombinations(digits));
	}

}
