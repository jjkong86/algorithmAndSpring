package reetCodeAlgorithms.Longest_Consecutive_Sequence;

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // 가장 긴 연속적인 서브 시퀀스
        // 복잡도는 O(n)
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int len = nums.length;
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        //System.out.println(Arrays.toString(nums));
        for (int i=1; i<len; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                count ++;
                max = Math.max(count, max);
            } else if (nums[i-1] == nums[i]) {
              continue;  
            } else {
                count = 1;
            }
        }
        return max;
    }
}
