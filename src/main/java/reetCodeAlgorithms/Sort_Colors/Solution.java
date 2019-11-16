package reetCodeAlgorithms.Sort_Colors;

/*
 * 정렬 라이브러리를 사용하지 않고 O(n)의 시간 복잡도로 풀어야 하는 문제
 * / red / white / blue
 * red의 index, white의 index(red index + white count), blue의 index는 for문의 i
 * 주의할 점은 발견한 숫자가 0인경우이다.
 *  - 0과 1을 스왑하고 1과 2를 스왑해야 올바른 정렬이 됨
 *  - white count가 0일때와 아닐때를 구분해서 해야함(즉, red의 index와 white의 index가 같지 않아야 올바른 정렬이됨) 
 * */
class Solution {
	public void sortColors(int[] nums) {
		int index = 0, oneCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == 1) {
				swap(nums, index + oneCount++, i);
			} else if (num == 0) {
				// 0 <> 1, 1 <> 2
				swap(nums, index, i);
				if (oneCount != 0)
					swap(nums, index + oneCount, i);
				index++;
			}
		}
	}

	public void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
