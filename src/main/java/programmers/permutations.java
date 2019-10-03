package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class permutations {
	public static List<String> permute(String str) {
		HashSet<String> set = new HashSet<>();
		List<String> list = new ArrayList<>(makePermute(set, str, ""));
		return list;
	}
	
	public static HashSet<String> makePermute(HashSet<String> set, String str, String save) {
		if (str.length() == 0) {
			set.add(save);
			return set;
		}
		for (int i=0; i<str.length(); i++) {
			String temp = str.substring(i, i+1);
			String resStr = subtractStr(str, i);
			set = makePermute(set, resStr, temp + save);
		}
		return set;
	}
	
	public static String subtractStr(String str, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i == index) continue;
			sb.append(str.substring(i, i+1));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		List<String> set = permute("abc");
		System.out.println(set.toString());
	}
}
