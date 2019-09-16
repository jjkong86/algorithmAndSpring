package reetCodeAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		Collections.sort(list2);
		System.out.println(list2.toString());
	}
}
