package reetCodeAlgorithms.Rotate_Image;

import java.util.Arrays;

class Solution {
	public void rotate(int[][] matrix) {
		//
		int len = matrix[0].length;
		int[][] res = new int[matrix.length][len];

		for (int i = 0; i < len; i++) {
			for (int j = matrix.length - 1; j >= 0; j--) {
				res[i][matrix.length - 1 - j] = matrix[j][i];
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = Arrays.copyOf(res[i], matrix[i].length);
		}
	}
}
