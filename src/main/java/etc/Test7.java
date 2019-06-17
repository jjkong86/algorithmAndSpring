package etc;

import java.util.*;

public class Test7 {
	
	public static class Cup {
		int size;
		
		public Cup(int i) {
			this.size = i;
		}
		
		public int getSize() {
			return size;
		}
	}
	
	public static void main(String[] args) {
		TreeMap<Cup, Double> map = new TreeMap<Cup, Double>((c1, c2)-> Integer.compare(c2.getSize(), c1.getSize()));
		map.put(new Cup(3), new Double(0.34));
		map.put(new Cup(1), new Double(123.22));
		map.put(new Cup(2), new Double(178.00));
		
		map.forEach((k, v)-> System.out.println(k.getSize() + "," +v));
		System.out.println(map.firstEntry().getKey().getSize());
		System.out.println(map.lastEntry().getKey().getSize());
	}
}
