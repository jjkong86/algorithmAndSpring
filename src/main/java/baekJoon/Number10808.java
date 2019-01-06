package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Number10808 {

	public static void main(String[] args) throws IOException {
		//string을 받아서 a ~ z 까지 각각 갯수 출력
		// char 97 ~ 122 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArray = br.readLine().toCharArray();
		Map<String, Integer> map = new HashMap<>();
		for (char i = 97; i <= 122; i++) {
			map.put(Character.toString(i), 0);
		}
		for (char c : charArray) {
			if (c >= 97 && c <= 122) {
				String s = Character.toString(c);
				map.put(s, map.get(s)+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	    	Entry<String, Integer> pairs = it.next();
	        sb.append(pairs.getValue() + (it.hasNext() == true ? " " : ""));
	    }
	    System.out.println(sb);
	}
}
