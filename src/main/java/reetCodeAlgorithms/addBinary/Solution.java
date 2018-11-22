package reetCodeAlgorithms.addBinary;

public class Solution {
	public static String addBinary(String a, String b) {
		StringBuilder tempResult = new StringBuilder();
		int carry = 0;
		int aLength = a.length();
		int bLength = b.length();
		
		while (aLength > 0 || bLength > 0) {
			int aNumber = aLength == 0 ? 0 : Integer.valueOf(a.substring(aLength-1, aLength));
			int bNumber = bLength == 0 ? 0 : Integer.valueOf(b.substring(bLength-1, bLength));
			int sum = carry + aNumber + bNumber;
			carry = (int)sum/2;
			tempResult.append(String.valueOf(sum%2));
			
			aLength = aLength == 0 ? 0 : aLength - 1;
			bLength = bLength == 0 ? 0 : bLength - 1;
		}
		
		if(carry > 0) {
			tempResult.append(carry);
		}
		
//		String result = "";
//		for (int i = tempResult.length()-1; i >= 0 ; i--) {
//			result += tempResult.substring(i, i+1);
//		}
		
		return tempResult.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("101", "1111"));
	}
}
