package reetCodeAlgorithms.Integer_to_Roman;

public class Solution {

	public String intToRoman(int num) {
		/*
			4는 IV
			int num -> /2, /5 두가지로 나뉨
			flag로 분기처리 필요
			문자 조합은 작은 수가 왼쪽
		 */
		if(num == 0) {
			return null;
		}
		
		final int I = 1;
		final int V = 5;
		final int X = 10;
		final int L = 50;
		final int C = 100;
		final int D = 500;
		final int M = 1000;
		// 1994 = MCMXCIV 
		// 58 = LVIII
		boolean dFlag = false;
		
		
		if (num < 10) {
			return "";
		}
		
		int divide = 10;
		while (num / divide > 0) {
			
			divide = 10;
		}
        
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(1234));
	}

}
