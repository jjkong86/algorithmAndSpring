package reetCodeAlgorithms.Trapping_Rain_Water;

class Solution {
    public int trap(int[] height) {
        // 배열에서 물이 저장된 양을 반환
        // 저장되는 조건은??
        // 배열 index 차이가 최소 2이상이고 사이값보다 커야함
        // height[i] > height[i+1] 이면 값을 계산 해봐야함
        if (height.length < 1) return 0;
        int len = height.length;
        int left = 0, right = 0, sum = 0;
        boolean calFlag = false;
        
        for (int i=0; i<len-1; i++) {
        	if (height[i] > height[i+1]) {
                if (calFlag) {
                    int minValue = Math.min(height[left], height[right]);
                    for (int j=left+1; j<i; j++) {
                        sum += minValue - height[j];
                    }
                    calFlag = false;
                } else {
                    left = i;
                    calFlag = true;
                }
            }
            right = i;
        }
        
        return 0;
    }
}
