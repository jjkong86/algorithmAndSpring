package reetCodeAlgorithms.House_Robber;

public class Solution2 {
	public int rob(int[] nums) {
		// dp배열을 사용하지 않고 int 변수만 사용하여 공간 복잡도 줄임
		if (nums.length == 0)
			return 0;

		int prev = 0, prevPrev = 0;
		for (int num : nums) {
			int temp = prev;
			prev = Math.max(prevPrev + num, prev);
			prevPrev = temp;
		}
		return prev;
	}
}
