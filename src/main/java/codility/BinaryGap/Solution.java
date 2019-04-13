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
	    int saveIndex = 0;
	    int count = 0;
		int max = 0;
		while (N > 0) {
			int remainder = N % 2;
			N /= 2;
			if (remainder == 1) {
			    array[saveIndex++] = count;
			}
			count ++;
		}
		
		for (int i=1; i < saveIndex; i++) {
		    int temp = array[i] - array[i-1] -1;
		    if (temp > max) {
		        max = temp;
		    }
		}
     return max;
	}
}
