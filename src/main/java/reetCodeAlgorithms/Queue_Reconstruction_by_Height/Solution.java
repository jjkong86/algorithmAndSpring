package reetCodeAlgorithms.Queue_Reconstruction_by_Height;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

class Solution {
	public int[][] reconstructQueue(int[][] p) {
		// [x, y] -> x : 키, y : 키가 크거나 같은 사람이 앞에 있는 수
		// 앞에서부터 채워가면??
		if (p == null || p.length < 1)
			return new int[][] {};

		int len = p.length;
		for (int i = 0; i < len; i++) {
			int[] minQueue = p[i];
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (compareTo(minQueue, p[j])) {
					minQueue = p[j];
					minIndex = j;
				}
			}
			swich(p, i, minIndex);
		}

		for (int[] is : p) {
			System.out.println(Arrays.toString(is));
		}

		return p;
	}

	public boolean compareTo(int[] minQueue, int[] array) {
		if (minQueue[1] == array[1])
			return Integer.compare(minQueue[0], array[0]) > 0;
		else
			return Integer.compare(minQueue[1], array[1]) > 0;
	}

	private void swich(int[][] p, int index, int minQueueIndex) {
		int[] temp = p[index];
		p[index] = p[minQueueIndex];
		p[minQueueIndex] = temp;
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(new int[][] { { 5, 0 }, { 7, 0 }, { 5, 2 }, { 6, 1 }, { 4, 4 }, { 7, 1 } },
					is(s.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } })));
		}

	}

}
