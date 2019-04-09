package codewars.Double_Cola;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Line {
	public static String WhoIsNext(String[] names, int n) {
		// Your code is here...
		// 선입선출로 줄을 서고 있음(1,2,3,4,5) -> pop -> 2,3,4,5,1,1 - > pop -> 3,4,5,1,1,2,2
		// 1 <= n <= 10000000000
		PriorityQueue<String> que = new PriorityQueue<>();
		IntStream.range(0, names.length).forEach(i -> que.add(names[i]));
		String ret = "";
		while (n > 0) {
			String str = que.poll();
			IntStream.range(0, 2).forEach(i -> que.add(str));
			if (--n == 0) {
				ret = str;
				break;
			}
		}
		return ret;
	}
}
