package etc;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println(list.get(0));
		BigDecimal b = new BigDecimal(0.13424);
		System.out.println(b.multiply(BigDecimal.TEN.pow(18)));
		
		System.out.println(new BigDecimal("232456560000000000").divide(BigDecimal.TEN.pow(18)));
		
		String[] str = "0.13424".split("\\.");
		
		System.out.println(str);
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("aa", "aa");
		
		if (StringUtils.isNullOrEmpty(map1.get("bb"))) {
			System.out.println("없음!");
		}
			
		String test1 = "1234567";
		System.out.println(test1.substring(2));
		
		
	}
	
	private static void change(Node n, int val) {
		n.val = val;
	}

	static class Node {
		int val;
		Node(){
			this.val = 0;
		}
	}
}
