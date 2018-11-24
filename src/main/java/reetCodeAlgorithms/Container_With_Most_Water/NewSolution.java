package reetCodeAlgorithms.Container_With_Most_Water;

public class NewSolution {
	public int maxArea(int[] height) {
		/*
        숫자를 뽑아서 그 수보다 크거나 같은 수 중 떨어진 거리가 가장 먼 수의 좌표
        max(maxArea, min(int[i], int[j]) * (i - j))
        */
        int left = 0, right = height.length -1;
        int maxArea = 0;
        while (right > left) {
        	maxArea = Math.max(maxArea, Math.min(height[left], height[right])*(right - left));
        	if (height[left] >= height[right]) {
        		right--;
        	} else if( height[left] < height[right]) {
        		left++;
        	}
        }
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(s.maxArea(height));
	}
}
