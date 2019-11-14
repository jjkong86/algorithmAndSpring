package programmers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

// 깊이 우선 탐색으로 풀었음, 케이스는 각각 두가지기 때문에 index의 숫자와 -1을 곱해서 합을 구한뒤 같으면 +1
public class P43165 {

	public int solution(int[] numbers, int target) {
		return findCount(numbers, target, 0);
	}

	public int findCount(int[] numbers, int target, int index) {
		if (index == numbers.length) {
			return Arrays.stream(numbers).sum() == target ? 1 : 0;
		}

		int result = 0;
		result += findCount(numbers, target, index + 1);
		numbers[index] = numbers[index] * (-1);
		result += findCount(numbers, target, index + 1);
		return result;
	}

	public static class TestClass {
		P43165 p = new P43165();

		@Test
		public void test1() {
			assertThat(5, is(p.solution(new int[] { 1, 1, 1, 1, 1 }, 3)));
		}

		@Test
		public void test2() {
			assertThat(0, is(p.solution(new int[] { 50, 1 }, 2)));
		}

	}
}
