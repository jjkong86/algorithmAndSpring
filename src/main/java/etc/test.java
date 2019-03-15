package etc;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		int[] array = new int[] { 5, 654, 3, 4, 5 };
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
		IntStream.range(0, 5).forEach(i -> a.add(array[i]));
		System.out.println(a);
		StringJoiner sj = new StringJoiner(", ");
		IntStream.range(0, 5).forEach(i -> sj.add(String.valueOf(array[i])));

		String[] arr = new String[] { "d" ,"a", "b", "c" };
		StringJoiner sj2 = new StringJoiner(", ");
		IntStream.range(0, arr.length).forEach(i -> sj2.add(arr[i]));
		System.out.println(sj2);
		List<String> list = new ArrayList<String>(Arrays.asList(arr));

 		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String str = it.next();
   			if (str.startsWith("c")) {
				it.remove();
			}
		}
		if (list.contains("b")) {
			System.out.println(":::::" + list.get(1));
		}
		
		LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
		if (linkedList.contains("a")) {
			System.out.println("a 있음");
		}
		linkedList.remove("a");
		System.out.println(linkedList.getFirst());
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		sb.append("abcvd");
		sb.delete(0, 1);
		System.out.println(sb);
		
		
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
