package codewars.Weight_for_weight;

import java.util.*;
import java.util.stream.*;
import org.springframework.util.StringUtils;

public class WeightSort {

	public static String orderWeight(String strng) {
		// your code
	    // 가중치는 각 자리들의 숫자를 더한값
	    // 가중치가 같다면 앞자리 부터 작은 수
	    if (!StringUtils.hasText(strng)) return "";
	    
	    StringJoiner sj = new StringJoiner(" ");
	    String[] split = strng.split(" ");
	    Weight[] we = new Weight[split.length];
	    for (int i = 0; i < split.length; i++) {
			we[i] = new Weight(split[i], toWeight(split[i]));
		}
//	    we = Stream.of(split).map(s -> new Weight(s, toWeight(s))).toArray();
	    Arrays.sort(we);
	    Stream.of(we).map(w -> sj.add(w.number));
	    for (int i = 0; i < we.length; i++) {
			sj.add(we[i].number);
		}
	    return sj.toString();
	}

	public static int toWeight(String s) {
		return Stream.of(s.split("")).mapToInt(str -> Integer.parseInt(str)).sum();
	}

	public static class Weight implements Comparable<Weight> {
		String number;
		int weight;

		public Weight(String n, int w) {
			this.number = n;
			this.weight = w;
		}

		@Override
		public int compareTo(Weight w) {
			if (this.weight != w.weight) return Integer.compare(this.weight, w.weight);
			if (this.number.equals(w.number)) return 0;
			
			int thisLen = this.number.length();
			int wLen = w.number.length();
			int len = thisLen < wLen ? thisLen : wLen;
			for (int i = 0; i < len; i++) {
				char thisC = this.number.charAt(i);
				char wC = w.number.charAt(i);
				if (thisC == wC) continue;
				
				return Character.compare(thisC, wC);
			}
			return Integer.compare(thisLen, wLen);
		}
	}
}
