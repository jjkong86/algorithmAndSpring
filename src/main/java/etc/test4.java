package etc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test4 {
	public static void main(String[] args) {
		String a = "1 2 3456";
		System.out.println(a.substring(0));
		System.out.println(a.substring(0, 1));
		System.out.println(Stream.of(a.split(" ")).map(str -> str).collect(Collectors.joining(" ")));
		System.out.println(Character.isLetter(a.charAt(0)));
		List<String> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		
		BigDecimal gasAmount = new BigDecimal("21000");
		BigDecimal gasPrice = new BigDecimal("30");
		BigDecimal cal = gasAmount.multiply(gasPrice).divide(BigDecimal.TEN.pow(9));
		System.out.println(new BigDecimal("0.4921562").subtract(cal));
		
		for (int i = 1; i < 100; i++) {
			int index = 0;
			int chkInt = 0;
			while (chkInt <= i) {
				chkInt = (int)Math.pow(2, ++index);
			}
			System.out.println(i+"::"+index);
			
		}
	}
}
