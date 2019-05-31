package reetCodeAlgorithms.Trapping_Rain_Water;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

class Solution {
    public int trap(int[] h) {
        // 물이 고이는 조건 : 두 수의 사이값이 작은 경우
        // left, right 두부분 으로 나눔 -> left는 왼쪽을 벽으로 생각, right는 오른쪽을 벽으로 생각
    	if ( h.length <= 2 ) { return 0; }
//        System.out.println(Arrays.toString(h));
        int left = 0, right = h.length-1, totalArea = 0;
        int leftMaxHeight = h[left], rightMaxHeight = h[right];
        
        while ( left < right ) {
//        	System.out.println(h[left] + "::"+h[right]);
            if ( h[left] < h[right] ) {
                leftMaxHeight = Math.max(leftMaxHeight, h[++left]);
                totalArea += leftMaxHeight-h[left];
            } else {
                rightMaxHeight = Math.max(rightMaxHeight, h[--right]);
                totalArea += rightMaxHeight-h[right];
            } 
        }
        return totalArea;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(6, is(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})));
    	}
    }
}
