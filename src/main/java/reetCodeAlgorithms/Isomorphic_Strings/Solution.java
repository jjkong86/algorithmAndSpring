package reetCodeAlgorithms.Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s.equals(""))
			return true;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				int left = map.get(chars[i]);
				return t.charAt(left) == t.charAt(i);
			}
			map.put(chars[i], i);
		}
		return false;
	}
}
