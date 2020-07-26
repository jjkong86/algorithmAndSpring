package reetCodeAlgorithms.Count_Servers_that_Communicate;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    // row, column 연결 되어 있어야함, 연결된 총 count
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rowLength = grid.length, columnLength = grid[0].length;
        int[] row = new int[rowLength];
        int[] col = new int[columnLength];
        for (int i = 0; i < rowLength; ++i) {
            for (int j = 0; j < columnLength; ++j) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < rowLength; ++i) {
            for (int j = 0; j < columnLength; ++j) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1))
                    res++;
            }
        }

        return res;
    }

    @Test
    public void countServers() {
        Assert.assertEquals(3, new Solution().countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
    }

}
