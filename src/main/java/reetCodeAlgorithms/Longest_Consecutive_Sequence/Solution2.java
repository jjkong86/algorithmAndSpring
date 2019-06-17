package reetCodeAlgorithms.Longest_Consecutive_Sequence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;

        for (int num : num_set) {
        	//연속된 서브 시퀀스 중 가장 작은 숫자를 찾아 들어가서  maxLength를 구함
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    
    
    public static class TestClass {
    	Solution2 s = new Solution2();
    	@Test
    	public void test1() {
    		assertThat(4, is(s.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2})));
    	}
    	
    }
}
