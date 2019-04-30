package etc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.CollectionUtils;

public class test4 {
	public static void main(String[] args) {
		String a = "1 2 3456";
		System.out.println(a.substring(0));
		System.out.println(a.substring(0, 1));
		System.out.println(Stream.of(a.split(" ")).map(str -> str).collect(Collectors.joining(" ")));
		System.out.println(Character.isLetter(a.charAt(0)));
		List<Map<String, Integer>> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map1 = new HashMap<>();
		map.put("liquidweb.com", 80000);
		list.add(map);
		map1.put("linode.com", 90000);
		list.add(map1);
		Map<String, Integer> saveMap = new HashMap<>();
		try {
			saveMap = 
				new HashMap<>(
						list.stream()
						.filter(i -> i.get("linode.com") == map1.get("linode.com"))
						.collect(Collectors.toList()).get(0));
			System.out.println(saveMap.toString());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("없음");
		}

		
		
	}
}
