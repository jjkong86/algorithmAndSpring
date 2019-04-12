package codility.BinaryGap;

// https://app.codility.com/c/run/trainingXC3EAS-BVH/
class Solution {
	public static int solution(int N) {
		// write your code in Java SE 8
		// 2진수로 변환 후 1과 1사이 간격이 가장 큰 수를 반환, 1이 하나 이하이면 0을 반환
		int index = 0;
		int chkInt = 0;
		while (chkInt <= N) {
		    chkInt = (int)Math.pow(2, ++index);
		}
		
		int[] array = new int[index];
		index --;
		int max = 0;
		while (N > 0) {
			int remainder = N % 2;
			array[index--] = remainder;
			N /= 2;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				int count = 0;
				for (int j = i + 1; j < array.length; j++) {
					if (array[j] == 1) {
						if (count > max) {
							max = count;
						}
						break;
					}
					count++;
				}

			}

		}
     return max;
	}
}
