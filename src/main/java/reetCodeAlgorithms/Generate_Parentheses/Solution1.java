package reetCodeAlgorithms.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backTracking(list, "", 0, 0, n);
	
		return list;
		
		
	}
	private void backTracking(List<String> list, String s, int open, int close, int n) {
		if (s.length() == n*2) {
			list.add(s);
			return;
		}
		if (open < n) {
			backTracking(list, s+"(", open+1, close, n);
		}
		if (close < open) {
			backTracking(list, s+")", open, close+1, n);
		}
		
	}
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.generateParenthesis(3));

	}

}
