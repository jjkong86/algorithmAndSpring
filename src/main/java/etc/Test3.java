package etc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.TimeZone;

public class Test3 {
	private static int number;

	public Test3(int number) {
		this.number = number;
	}

	public static class Inner {
		public void innerTest() {
			System.out.println(number);

			Map<String, Object> map = new HashMap<>();
			map.put("123", 123);
			Iterator i = map.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry<String, Object> entry = (Entry<String, Object>) i.next();
				int number = (int) entry.getValue();
			}
		}
	}

	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS", Locale.US);
		simpleDateFormat.setTimeZone(timeZone);
		
		System.out.println("Time zone: " + timeZone.getID());
		System.out.println("default time zone: " + TimeZone.getDefault().getID());
		System.out.println();
		Random ran = new Random();
		for (int i = 0; i < 1; i++) {
			Calendar calendar = Calendar.getInstance(timeZone);
			System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
		}
		
		BigDecimal big = new BigDecimal(new BigInteger("a", 16));
		System.out.println(big);
		
		DecimalFormat df = new DecimalFormat("#.##################");
		for (int i = 1; i <= 16; i++) {
			big = big.divide(BigDecimal.TEN.pow(1));
			String result = df.format(big.doubleValue());
			System.out.println(result);
		}
		
		
	
	}

}
