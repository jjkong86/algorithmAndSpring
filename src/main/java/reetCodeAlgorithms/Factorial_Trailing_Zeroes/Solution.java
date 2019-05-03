package reetCodeAlgorithms.Factorial_Trailing_Zeroes;

class Solution {
	public static int trailingZeroes(int n) {
		// !n의 값에서 0 개수를 출력
		// 0이 되는 경우의 수 : 2*5 -> 각 주어지는 숫자를 소인수 분해하여
		// 2와 5애 개수
		int fiveCount = 0;
		System.out.println(n/5);
		int[] array = new int[n/5+1];
		for (int i = 5; i <= n; i+=5) {
            fiveCount += primerize(array, i);
		}
		return fiveCount;
	}

	public static int primerize(int[] array, int num) {
		int cal = num;
		int fiveCount = 0;
		while (cal > 1) {
			if (cal % 5 == 0) {
				cal /= 5;
				fiveCount++;
				if (array[cal/5] != 0) {
  					array[num/5] = fiveCount + array[cal/5];
					return array[num/5];
				}
			} else {
				break;
			}
		}
		array[num/5] = fiveCount;
		return fiveCount;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(2147483647));
	}
}
