package reetCodeAlgorithms.Daily_Temperatures;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

class Solution {
	public int[] dailyTemperatures(int[] T) {
		// 현재보다 더 따뜻해 지는 날짜 수를 구해야함
		// map 이용해서 nlogn 정도로 해보면?
		int len = T.length;
		int[] res = new int[len];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len - 1; i++) {
			int num = T[i];
			if (num < T[i + 1]) {
				res[i] = 1;
			} else {
				map.put(i, num);
			}

			for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry<Integer, Integer> entry = it.next();
				if (entry.getValue() < T[i + 1]) {
					res[entry.getKey()] = i - entry.getKey() + 1;
					it.remove();
				}
			}
		}

		return res;
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
			assertThat(new int[] {8,1,5,4,3,2,1,1,0,0 },
					is(s.dailyTemperatures(new int[] { 89,62,70,58,47,47,46,76,100,70 })));
		}

	}
}
