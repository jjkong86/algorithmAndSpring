package codility.BinaryGap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
	
	@Test
	public void test01() {
		assertEquals(5, Solution.solution(1041));
		assertEquals(0, Solution.solution(15));
		assertEquals(0, Solution.solution(32));
		assertEquals(2, Solution.solution(328));
		assertEquals(2, Solution.solution(51712));
	}
}
