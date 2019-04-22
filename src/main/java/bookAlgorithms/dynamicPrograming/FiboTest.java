package bookAlgorithms.dynamicPrograming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiboTest {
	@Test
	public void test1() {
		int number = 7;
		long[] array = new long[number+1];
		assertEquals(13, Fibonazzi.fibonazzi(array, number));
	}

	@Test
	public void test2() {
		int number = 131;
		long[] array = new long[number+1];
		assertEquals(34, Fibonazzi.fibonazzi(array, number));
	}

}
