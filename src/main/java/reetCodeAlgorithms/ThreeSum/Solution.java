package reetCodeAlgorithms.ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		// 세 숫자의 합이 0이 되는 경우를 찾아서 리턴
        // 배열을 정렬 후 차례대로 숫자를 선정
        // 두 수는 배열의 양쪽을 초기값으로 하고 0보다 작으면 왼쪽 index ++, 0보다 크면 오른쪽 index --
        // 찾았으면 list에 넣어주고 같은 숫자가 있는지 찾아서 건너뛰게해줌. 
        List<List<Integer>> list = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<len-1; i++) {
            int le = i+1;
            int ri = len -1;
            while (ri > le) {
                int sum = nums[i] + nums[le] + nums[ri];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[le], nums[ri]));
                    while (ri > le && nums[le] == nums[le+1]) le++;
                    while (ri > le && nums[ri] == nums[ri-1]) ri--;
                    le++; ri--;
                } 
                else if (sum < 0) le++;
                else ri--;
            }
            
            while (len-1 > i && nums[i] == nums[i+1]) i++;
        }
        return list;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(s.threeSum(nums).toString());

	}

}
