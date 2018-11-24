package reetCodeAlgorithms.Container_With_Most_Water;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public int maxArea(int[] height) {
		/*
        숫자를 뽑아서 그 수보다 크거나 같은 수 중 떨어진 거리가 가장 먼 수의 좌표
        max(min(int[i], int[j]) * (i - j))
        */
        
//        List<Integer> list = Arrays.stream(height).boxed().collect(Collectors.toList());
        
        int maxL = 0;
        int maxA = 0;
        for(int i=0; i < height.length; i++) {
        
            for(int j=0; j<height.length; j++) {
            	maxL = Math.abs(i - j);
                if(Math.min(height[i], height[j]) * maxL >= maxA) {
                    maxA = Math.min(height[i], height[j]) * maxL;
                }    
            }
        }
		return maxA;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(s.maxArea(height));
	}

}
