package reetCodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Test123 {
	
	public static class RedisTknInfo implements Comparable<RedisTknInfo>{
		String key;
		String unfyMmbNo;
		long time;
		
		public RedisTknInfo() {}
		
		public RedisTknInfo(long time) {
			this.time = time;
			
		}

		@Override
		public int compareTo(RedisTknInfo info) {
			return Long.compare(time, info.time);
		}
		
		@Override
		public String toString() {
			return String.valueOf(time);
		}
	}
	
	public static void main(String[] args) {
		String[] names = new String[] {"1", "2", ""};
		
		System.out.println((names == null) == false);
		
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		set.addAll(list);
		
		String[] res = Arrays.stream(names).filter(s -> !s.equals("")).toArray(String[]::new);
		System.out.println(Arrays.toString(res));
		
		System.out.println(Long.compare(4, 5));
		
		List<RedisTknInfo> list2 = new ArrayList<>();
		list2.add(new RedisTknInfo(1));
		list2.add(new RedisTknInfo(2));
		list2.add(new RedisTknInfo(3));
		
		RedisTknInfo[] result = list2.stream().toArray(RedisTknInfo[]::new);
		System.out.println(Arrays.toString(result));
		
		Collections.sort(list2);
		System.out.println(list2.toString());
		
		System.out.println(Arrays.asList("1", "2", "3"));
		System.out.println(Arrays.asList(new String[] {"1", "2", "3"}));
		
		System.out.println("12345".indexOf("123"));
		
		String str = "";
		int index = str.indexOf("4");
		System.out.println(index);
		str = str.substring(0, index) + str.substring(index+1);
		System.out.println(str);
	}
}
