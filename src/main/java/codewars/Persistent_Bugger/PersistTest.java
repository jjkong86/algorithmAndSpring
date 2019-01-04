package codewars.Persistent_Bugger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersistTest {

	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(3, Persist.persistence(39));
		assertEquals(0, Persist.persistence(4));
		assertEquals(2, Persist.persistence(25));
		assertEquals(4, Persist.persistence(999));
	}

	public static class Persist {

		public static int persistence(long n) {
			// your code
			int count = 0;
			if (n < 10) {
				return count;
			}
			count = persistence(n, count+1);

			System.out.println("count : " + count);
			return count;
		}

		public static int persistence(long n, int count) {
			long temp = 1;
			while (n > 0) {
				temp *= n % 10;
				n = n / 10;
			}

			if (temp > 9) {
				count = persistence(temp, count+1);
			} else {
				return count;
			}
			return count;
		}
	}
}
