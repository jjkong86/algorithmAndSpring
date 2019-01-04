package etc.lambdaAndStream;

import java.util.*;
import java.util.stream.Stream;

public class test {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("Hello World.");
		}).start();

		Func add = (int a, int b) -> a + b;
		Func add2 = (int a, int b) -> {return a+b;};
		System.out.println(add.calc(3, 4));
		System.out.println(add2.calc(3, 4));
		
		Stream<Integer> sum = Arrays.asList(1,2,3).stream().parallel();
		System.out.println(sum.filter(i -> i%2==0).findFirst().get());
		
		int sum2 = Arrays.asList(1,2,3).stream().mapToInt(i -> i*i).max().getAsInt();
		System.out.println(sum2);
		
		Arrays.asList(1,2,3).stream()
		.filter(i-> 2>=i)
		.forEach(System.out::println); // 1,2
		
		System.out.println(Arrays.asList(1,2,3).stream().reduce((a,b)-> a-b).get());
	}

	@FunctionalInterface
	interface Func {
		public int calc(int a, int b);
	}
}
