package baekJoon.Number11653;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
	@Test
	public void BasicTests() {
		assertEquals("3\n" + 
				"5\n" + 
				"7\n" + 
				"11\n" + 
				"13\n", Main.primeCount(3, 16));
	}
}
