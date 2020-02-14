package codility.MissingInteger;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int num : A) {
			if (num > 0)
				set.add(num);
		}

		for (int i = 0; i <= A.length; i++) {
			if (!set.contains(i + 1))
				return i + 1;
		}

		return 1;
	}
}
