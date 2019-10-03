package etc.배민;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

public class Test3 {
	public int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int left = 0, right = A.length - 1;

		while (A[left] < 0 && A[right] > 0 && right > left) {
			int leftNum = Math.abs(A[left]);
			int rightNum = A[right];
			if (leftNum == rightNum)
				return rightNum;
			else if (leftNum > rightNum)
				left++;
			else if (leftNum < rightNum)
				right--;
		}

		return 0;
	}
	
	public static class TestClass {
		Test3 t = new Test3();
		@Test
		public void test1() {
//			assertThat(3, is(t.solution(new int[] {3,2,-2,5,-3})));
//			assertThat(0, is(t.solution(new int[] {-3,2,2,5,-3, 6, -7})));
//			assertThat(0, is(t.solution(new int[] {1,1,1,1,1})));
//			assertThat(1, is(t.solution(new int[] {1,1,1,1,-1})));
			assertThat(0, is(t.solution(new int[] {-3,-2,5,6})));
		}
		
	}
}
