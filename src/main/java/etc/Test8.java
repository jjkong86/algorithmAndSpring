package etc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test8 {
	
	public static void thread() {
        new Thread(() -> {
        	int count = 0;
            System.out.println(count++);
        }).run();
		
	}
	
	public static void main(String[] args) {
//		thread();
		DecimalFormat fmt = new DecimalFormat("#.##########");
		double[] array = new double[] {0.05, 0.03480533, 0.0000001, 1.1345};
		for (double d : array) {
			String str = fmt.format(d);
			System.out.println(str);
			System.out.println(new BigDecimal(str));
		}
	}
}
