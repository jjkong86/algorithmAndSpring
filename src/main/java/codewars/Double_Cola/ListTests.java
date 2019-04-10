package codewars.Double_Cola;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListTests {
	@Test
	public void test1() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 1;
		assertEquals("Sheldon", new Line().WhoIsNext(names, n));
	}

	@Test
	public void test2() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 20;
		assertEquals("Sheldon", new Line().WhoIsNext(names, n));
	}
	
//	@Test
//	public void test3() {
//		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
//		int n = Integer.MAX_VALUE;
//		assertEquals("Sheldon", new Line().WhoIsNext(names, n));
//	}
}
