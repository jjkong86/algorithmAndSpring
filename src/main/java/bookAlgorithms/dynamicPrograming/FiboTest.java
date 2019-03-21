package bookAlgorithms.dynamicPrograming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiboTest {
	@Test
	public void test1() {
		int number = 7;
		int[] array = new int[number+1];
		assertEquals(13, Fibonazzi.fibonazzi(array, number));
	}

	@Test
	public void test2() {
		int number = 131;
		int[] array = new int[number+1];
		assertEquals(34, Fibonazzi.fibonazzi(array, number));
	}

}
