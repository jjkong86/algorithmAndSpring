package etc.배민;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

class Test4 {
	int solution(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;

		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		for (int k = 0; k < n; k++) {
			while (i < m - 1 && B[i] < A[k]) {
				i += 1;
			}
			if (A[k] == B[i])
				return A[k];
		}
		return -1;
	}

	public static class TestClass {
		Test4 t = new Test4();

		@Test
		public void test1() {
			// assertThat(2, is(t.solution(new int[] {1, 3, 2, 1}, new int[] {4, 2, 5, 3,
			// 2})));
			// assertThat(-1, is(t.solution(new int[] {1, 3, 2, 1}, new int[] {4})));
			// assertThat(10, is(t.solution(new int[] { 1, 3, 2, 1, 10 }, new int[] { 10
			// })));
			assertThat(10, is(t.solution(new int[] { 10 }, new int[] { 4, 2, 5, 3, 10 })));
			assertThat(2, is(t.solution(new int[] { 1, 2, 10 }, new int[] { 4, 2, 5, 3, 10 })));
		}
	}
}
