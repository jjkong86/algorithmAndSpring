package codility.BinaryGap;

// https://app.codility.com/c/run/trainingXC3EAS-BVH/
class Solution {
	public static int solution(int N) {
		// write your code in Java SE 8
		// 2진수로 변환 후 1과 1사이 간격이 가장 큰 수를 반환, 1이 하나 이하이면 0을 반환
		int count = 0;
		int max = 0;
		int oneFlag = 0; // 1과 1사이를 구하기 위한 flag
		while (N > 0) {
			int remainder = N % 2;
			N /= 2;
			if (remainder == 1) {
				oneFlag++;
				if (oneFlag == 2) {
					max = count > max ? count : max;
					count = 0;
					oneFlag = 1;
					continue;
				}
			} else if (remainder == 0 && oneFlag == 1) {
				count ++;
			}
		}
		return max;
	}
}
