package reetCodeAlgorithms.Factorial_Trailing_Zeroes;

class Solution {
	public static int trailingZeroes(int n) {
		// !n의 값에서 0 개수를 출력
		// 0이 되는 경우의 수 : 2*5 -> 각 주어지는 숫자를 소인수 분해하여
		// 2와 5애 개수
		return primerize(n);
	}

	public static int primerize(int num) {
		int fiveCount=0;
        while(num>0){
        	num/=5;
        	fiveCount+=num;
        }
        return fiveCount;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(3213));
	}
}
