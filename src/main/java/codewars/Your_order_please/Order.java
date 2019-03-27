package codewars.Your_order_please;

import java.util.*;
import java.util.stream.*;

public class Order {
	public static String order(String words) {
		// 공백을 기준으로 문자를 자르고 자른 문자에서 숫자를 찾아야함
		String[] split = words.split(" ");
		StringJoiner sj = new StringJoiner(" ");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < split.length; i++) {
			String str = split[i];
			for (int j = 0; j < str.length(); j++) {
				System.out.println(str.substring(j, j + 1));
				int number = parseIntChk(str.substring(j, j + 1));
				if (number != 0) {
					map.put(number, i);
					break;
				}
			}
		}
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			sj.add(split[map.get(list.get(i))]);
		}
		return sj.toString();
	}

	public static int parseIntChk(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
