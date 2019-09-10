package reetCodeAlgorithms.Daily_Temperatures;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

class Solution {

	public int[] dailyTemperatures(int[] temperatures) {
		// 현재보다 더 따뜻해 지는 날짜 수를 구해야함
		// map 이용해서 nlogn 정도로 해보면?
		Deque<Integer> stack = new ArrayDeque<>();
		int[] ret = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int idx = stack.pop();
				ret[idx] = i - idx;
			}
			stack.push(i);
		}
		return ret;
	}

	public static class TestClass {
		Solution s = new Solution();

		@Test
		public void test1() {
			assertThat(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 },
					is(s.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
		}

		@Test
		public void test2() {
			assertThat(new int[] { 8, 1, 5, 4, 3, 2, 1, 1, 0, 0 },
					is(s.dailyTemperatures(new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 })));
		}

	}
}
