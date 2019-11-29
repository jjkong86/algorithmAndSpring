package programmers.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> set = new HashSet<>();
		int index = 0;
		while (index < words.length) {
			String temp = words[index];
			if (index > 0) {
				String prev = words[index - 1];
				if (prev.charAt(prev.length() - 1) != temp.charAt(0)) {
					return new int[] { (index % n) + 1, (index / n) + 1 };
				}
			}

			if (set.contains(temp)) {
				return new int[] { (index % n) + 1, (index / n) + 1 };
			}
			set.add(temp);
			index++;
		}
		return new int[2];
	}
}
