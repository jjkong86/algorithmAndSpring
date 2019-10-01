package codility.MissingInteger;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution2 {
	public int solution(int[] A) {
		// write your code
		if (A.length == 1)
			return A[0] == 1 ? 2 : 1;
		Set<Integer> set = Arrays.stream(A).boxed().filter(i -> i > 0).collect(Collectors.toSet());
		for (int num : A) {
			if (num > 0)
				set.add(num);
		}
		for (int i = 1; i <= A.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 1;
	}
}
