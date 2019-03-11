package etc;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		int[] array = new int[] {5,654,3,4,5};
		System.out.println(IntStream.of(array).reduce(0, Integer::sum));
		Map<String, Object> map = new HashMap<>();
		String aa = "12345";
		map.put("aa", aa);
		test t = new test();
		System.out.println(t);
		
		int number = 10;
		int sum = IntStream.range(1, number).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
		final int arraySum = 0;
		LongAdder a = new LongAdder();
		LongAdder a2 = new LongAdder();
		IntStream.range(0,5).forEach(i -> a.add(array[i]));
		System.out.println(a);
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, 5).forEach(i -> sj.add(String.valueOf(array[i])));
	}
	
	@Override
	public String toString() {
		Node n = new Node();
		return String.valueOf(n.val);
	}
	private static void change(Node n, int val) {
		n.val = val;
	}

	static class Node {
		int val;

		Node() {
			this.val = 3;
		}
	}
}
