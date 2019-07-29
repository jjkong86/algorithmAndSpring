package etc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
	}
}
