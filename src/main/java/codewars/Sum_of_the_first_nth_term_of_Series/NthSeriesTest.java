package codewars.Sum_of_the_first_nth_term_of_Series;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class NthSeriesTest {

	@Test
	public void test1() {
		assertEquals("1.57", NthSeries.seriesSum(5));
	}

	@Test
	public void test2() {
		assertEquals("1.77", NthSeries.seriesSum(9));
	}

	@Test
	public void test3() {
		assertEquals("1.94", NthSeries.seriesSum(15));
	}

	public static class NthSeries {

		public static Object seriesSum(int n) {
			// Happy Coding ^_^
			// return은 string, 0 -> 0.00, 소수점 두번째 자리에서 반올림
			// 자연수만 주어짐
			return series(n);
		}

		private static String series(int n) {
			double d = 0; 
			for (double i = 1; i <= n; i++) {
				d += 1/(1 + (i-1)*3);
			}
			return String.format("%.2f", d);
		}
	}
}
