package codility.CyclicRotation;

public class Solution {
	public int[] solution(int[] A, int K) {
		// 배열 a를 k번만큼 오른쪽으로 이동, 끝자리 수는 앞으로 이동
		// 배열 k % length 하면 중복해서 돌지 않을듯
		if (A.length < 1) return new int[] {};
		int len = A.length;
		int shift = K % len;
		int[] saveArray = new int[len];
		for (int i = 0; i < len; i++) {
			saveArray[(i + shift) % len] = A[i];
		}
		return saveArray;
	}
}
