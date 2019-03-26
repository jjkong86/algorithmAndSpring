package etc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
			while(i.hasNext()) {
				Map.Entry<String, Object> entry = (Entry<String, Object>) i.next();
				int number = (int) entry.getValue();
			}
		}
	}

}
