package reetCodeAlgorithms.Longest_Increasing_Path_in_a_Matrix;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

class Solution {
	int[][] topBottom;
	int[][] bottomTop;

	public int longestIncreasingPath(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			sb.append(Arrays.toString(matrix[i]) + "\n");
		}
		System.out.println(sb);
		
		// 가장 긴 증가 경로
		// 위에서 아래로, 아래에서 위로 두가지 모두 해보면 되나??
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int ver = matrix.length;
		int ho = matrix[0].length;

		topBottom = new int[ver][ho];
		bottomTop = new int[ver][ho];

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		topDown(matrix, q);

		q.offer(new int[] { ver - 1, ho - 1 });
		bottomUp(matrix, q);

		print();
		
		int max = 0;
		for (int i = 0; i < ver; i++) {
			for (int j = 0; j < ho; j++) {
				max = Math.max(max, Math.max(topBottom[i][j], bottomTop[i][j]));
			}
		}
		return max;
	}

	private void topDown(int[][] m, Queue<int[]> q) {
		if (q.isEmpty())
			return;

		int[] co = q.poll();
		int bottom = co[0], right = co[1];
		int current = m[bottom][right];
		boolean isIncrease = false;
		if (bottom - 1 >= 0 && m[bottom - 1][right] < current) {
			topBottom[bottom][right] = Math.max(topBottom[bottom][right], topBottom[bottom - 1][right] + 1);
			isIncrease = true;
		}

		if (right - 1 >= 0 && m[bottom][right - 1] < current) {
			topBottom[bottom][right] = Math.max(topBottom[bottom][right], topBottom[bottom][right - 1] + 1);
			isIncrease = true;
		}

		if (!isIncrease) {
			topBottom[bottom][right] = 1;
		}

		if (bottom + 1 <= m.length - 1)
			q.offer(new int[] { bottom + 1, right });
		if (right + 1 <= m[0].length - 1)
			q.offer(new int[] { bottom, right + 1 });

		topDown(m, q);
	}

	private void bottomUp(int[][] m, Queue<int[]> q) {
		if (q.isEmpty())
			return;

		int[] co = q.poll();
		int bottom = co[0], right = co[1];
		int current = m[bottom][right];
		boolean isIncrease = false;
		if (bottom + 1 < m.length && m[bottom + 1][right] < current) {
			bottomTop[bottom][right] = Math.max(bottomTop[bottom][right], bottomTop[bottom + 1][right] + 1);
			isIncrease = true;

		}
		if (right + 1 < m[0].length && m[bottom][right + 1] < current) {
			bottomTop[bottom][right] = Math.max(bottomTop[bottom][right], bottomTop[bottom][right + 1] + 1);
			isIncrease = true;
		}

		if (!isIncrease) {
			bottomTop[bottom][right] = 1;
		}

		if (bottom - 1 >= 0)
			q.offer(new int[] { bottom - 1, right });
		if (right - 1 >= 0)
			q.offer(new int[] { bottom, right - 1 });

		bottomUp(m, q);
	}
	
	public void print() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < topBottom.length; i++) {
			sb.append(Arrays.toString(topBottom[i]) + "\n");
		}
		System.out.println(sb);
		
		sb.setLength(0);
		for (int i = 0; i < bottomTop.length; i++) {
			sb.append(Arrays.toString(bottomTop[i]) + "\n");
		}
		System.out.println(sb);
		
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
//			assertThat(4, is(s.longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } })));
		}

		@Test
		public void test2() {
//			assertThat(4, is(s.longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 1, 1 } })));
		}
		
		@Test
		public void test3() {
			assertThat(6, is(s.longestIncreasingPath(new int[][] { { 7,8,9 }, { 9,7,6 }, { 7,2,3 } })));
		}

	}

}
