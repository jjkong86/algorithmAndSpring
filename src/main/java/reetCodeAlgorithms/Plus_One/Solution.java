package reetCodeAlgorithms.Plus_One;

class Solution {
    public int[] plusOne(int[] d) {
        int len = d.length;
        d[len-1] += 1;
        for (int i=len-1; i>=1; i--) {
            if (d[i] > 9) {
                d[i] = 0;
                d[i-1] += 1;
            } else {
                return d;
            }
        }
        
        int[] res = new int[len+1];
        if (d[0] > 9) {
            res[0] = 1;
            res[1] = 0;
            for (int i=2; i<res.length; i++) {
                res[i] = d[i-1];
            }
        } else {
            return d;
        }
        
        return res;
    }
}
