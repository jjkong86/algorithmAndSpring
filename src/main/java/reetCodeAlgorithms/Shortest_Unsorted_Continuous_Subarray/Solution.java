package reetCodeAlgorithms.Shortest_Unsorted_Continuous_Subarray;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    
    public static class NumAndIndex {
        int index;
        int num;
        
        NumAndIndex(int i, int n) {
            this.index = i;
            this.num = n;
        }
    }
    
    public int findUnsortedSubarray(int[] nums) {
        // 정렬되지 않은 하위 배열을 정렬하면 오름차순 정렬이 만족함, 중복된 수가 들어감
        // 이때 가장 짧은 하위 배열의 length
        // 전체 탐색으로 찾아서 최적화 해보면?
        
        int len = nums.length;
        if (len == 1) return 0;
        
        NumAndIndex[] array = new NumAndIndex[len];
        for (int i=0; i<len; i++) {
            array[i] = new NumAndIndex(i, nums[i]);
        }
        
        Arrays.sort(array, new Comparator<NumAndIndex>() {
			@Override
			public int compare(NumAndIndex c1, NumAndIndex c2) {
				System.out.println(Integer.compare(c1.num, c1.num));
				return Integer.compare(c1.num, c1.num);
			} 
        });
        
        int start = 0, end = 0;
        for (int i=0; i<len; i++) {
            NumAndIndex temp = array[i];
            if (i != temp.index) {
                start = i;
                break;
            }
        }
        if (start ==0) return 0;
        
        for (int i=len-1; i>start; i--) {
            NumAndIndex temp = array[i];
            if (i != temp.index) {
                end = i;
            }
        }
        return end-start+1;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(5, is(s.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})));
    	}
    }
}
