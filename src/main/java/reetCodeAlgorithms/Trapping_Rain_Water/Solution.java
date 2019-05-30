package reetCodeAlgorithms.Trapping_Rain_Water;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
    public int trap(int[] height) {
        // 배열에서 물이 저장된 양을 반환
        // 저장되는 조건은??
        // 배열 index 차이가 최소 2이상이고 사이값보다 커야함
        // height[i] > height[i+1] 이면 값을 계산 해봐야함
        if (height.length < 1) return 0;
        int max = 0, index = 0;
        int len = height.length;
        for(int i=0; i<len; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        
        int res = 0;
        for(int i=1; i<len; i++) {
            int temp = height[i];
            for (int j=i+1; j<len; j++) {
                if (temp < height[j] && i+2 <= j) {
                    int h = Math.min(temp, height[j]);
                    for (int k=i+1; k<j; k++) {
                        res += h-height[k];
                    }
                    i = j+1;
                    break;
                }
            }
        }
        
        
        return res;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(6, is(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})));
    	}
    }
}
