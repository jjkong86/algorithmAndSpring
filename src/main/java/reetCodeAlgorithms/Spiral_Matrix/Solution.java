package reetCodeAlgorithms.Spiral_Matrix;

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        int times = 0;
        int vertical = matrix.length-1, horizon = matrix[0].length-1;
        int v = 0, h = 0;
        int flag = 1;
        while(res.size() <= vertical * horizon) {
            
            while (h >= 0 || h <= vertical - times) {
                res.add(matrix[v][h]);
                h += 1*flag;
            }
            
            while (v >= 0 || h <= horizon - times) {
                res.add(matrix[v][h]);
                v += 1*flag;
            }
            times++;
            flag *= -1;
        }
        return res;
    }
}
