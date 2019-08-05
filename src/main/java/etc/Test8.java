package etc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test8 {
	
	public static class User {
		String name;
		String loc;
		User (String name, String loc) {
			this.name = name;
			this.loc = loc;
		}
		User () {}
	}
	
	public static void thread() {
        new Thread(() -> {
        	int count = 0;
            System.out.println(count++);
        }).run();
		
	}
	
	public static void main(String[] args) {
//		thread();
		
		String amount = "31";
		BigDecimal de = new BigDecimal(amount);
		System.out.println(de);
		BigInteger in = de.toBigInteger();
		System.out.println(in);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			list.add(i);
		}
		
		System.out.println(Double.valueOf((list.get(1) + list.get(2)))/2);
		
		User user = new User();
		System.out.println(user.loc);
		String str = "Error: This transaction requires a transaction fe"
				+ "e of at least 0.00406";
		System.out.println(str.indexOf("least"));
		String[] split = str.split("least");
		System.out.println(Arrays.toString(split));
		
		LinkedList<Integer> l = new LinkedList<>();
		l.add(3);
		l.add(4);
		System.out.println(l.indexOf(4));
		System.out.println(l.get(1));
		
		List<String> list1 = new ArrayList<>(Arrays.asList(str.split(" ")));
		System.out.println(list1.toString());
		Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
		System.out.println(list1.toString());
		
		MyFuction f = (a, b) -> a > b ? a : b;
		System.out.println(f.max(3, 4));
	}
	
	@FunctionalInterface
	interface MyFuction {
		public abstract int max(int a, int b);
	}
	
}
