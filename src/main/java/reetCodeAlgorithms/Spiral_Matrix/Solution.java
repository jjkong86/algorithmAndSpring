package reetCodeAlgorithms.Spiral_Matrix;

import java.util.List;

import java.util.*;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		int flag = 1;
		int count = 0, vertical = matrix.length - 1, horizon = matrix[0].length - 1;
		int v = 0, h = 0;

		while (vertical >= 0 && horizon >= 0) {
			while (v > 0 || v < vertical) {
				System.out.println(matrix[h][v] + ", v : " + v + ", h : " + h);
				res.add(matrix[h][v]);
				v += flag * 1;
			}

			while (h >= 0 || h <= horizon) {
				System.out.println(matrix[h][v] + ", v : " + v + ", h : " + h);
				res.add(matrix[h][v]);
				h += flag * 1;
			}
			flag *= -1;
			vertical--;
			horizon--;
		}
		return res;
	}
}
