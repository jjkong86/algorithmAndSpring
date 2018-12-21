package reetCodeAlgorithms.Palindrome_Number;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		int rInt = 0;
		if(x <0 ||  (x!=0 && x%10 == 0)) return false;
		while (x > rInt) {
			rInt = rInt * 10 + x % 10;
			x = x / 10;
		}
		System.out.println(rInt + "::" + x);
		return (x==rInt || x==rInt/10);
	}
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		int x = 32123;
		System.out.println(p.isPalindrome(x));

	}

}
