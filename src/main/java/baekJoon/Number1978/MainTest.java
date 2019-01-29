package baekJoon.Number1978;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
	@Test
	public void BasicTests() {
		assertEquals(3, baekJoon.Number1978.Main.primeCount(new int[] { 1, 3, 5, 7 }));
	}
}
