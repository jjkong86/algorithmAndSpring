package reetCodeAlgorithms.Container_With_Most_Water;

class Solution2 {
    public int maxArea(int[] h) {
        int len = h.length;
        int max = 0;
        for (int i=0; i<len; i++) {
            int num = h[i];
            for (int j=i; j<len; j++) {
                int temp = h[j];
                max = Math.max(max, Math.min(num, temp) * (j-i));
            }
        }
        return max;
    }
}
