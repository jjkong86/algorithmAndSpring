package test.npay;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Solution2 {
	public boolean solution(int[] A, int K) {
		//정렬된 배열에서 1 ~ k번째 수까지 있는지 체크, 코딩은 되어있고 조건을 수정이 필요한 문제
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] <= K && A[i] + 1 < A[i + 1]) // 기준 숫자 + 1과 다음 인덱스의 숫자를 비교 -> 연속되는가 체크하는것, 하지만 K의 숫자 까지만 비교
				return false;
		}
		if (A[0] != 1 || A[n - 1] < K)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution(new int[] { 1, 1, 2, 3, 3 }, 3) == true);
		System.out.println(s.solution(new int[] { 1, 1, 2, 3, 3 }, 4) == false);
		System.out.println(s.solution(new int[] { 1, 1}, 1) == true);
		System.out.println(s.solution(new int[] { 1, 1, 3 }, 2) == false);
		System.out.println(s.solution(new int[] { 2, 3 }, 3) == false);
		System.out.println(s.solution(new int[] { 3 }, 2) == false);
		System.out.println(s.solution(new int[] { 1, 2, 3, 4, 5 }, 3) == true);
		System.out.println(s.solution(new int[] { 1, 2, 4, 5 }, 3) == false);
	}

	public static class SolutionTest {
		Solution2 s = new Solution2();

		@Test
		public void test1() {
			assertThat(s.solution(new int[] { 1, 1, 2, 3, 3 }, 3), is(true));
		}
	}
}
