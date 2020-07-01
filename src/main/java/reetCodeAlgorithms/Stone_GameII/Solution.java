package reetCodeAlgorithms.Stone_GameII;

import javaStudy.enumType.DiceName;
import javaStudy.enumType.EnumFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    // 1 <= X <= 2M. Then, we set M = max(M, X). --> dp
    // [2,7,9,4,4], [2,9,0,6,10]
    //
    private static int[] sums;
    private static int[][] hash;

    public static int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0)
            return 0;

        int len = piles.length;
        sums = new int[len];
        hash = new int[len][len];
        sums[len - 1] = piles[len - 1];

        for (int i = len - 2; i >= 0; i--)
            sums[i] = sums[i + 1] + piles[i];

        System.out.println(Arrays.toString(sums));

        return helper(piles, 0, 1);
    }

    private static int helper(int[] a, int i, int M) {
        if (i == a.length) return 0;
        if (2 * M >= a.length - i) return sums[i];

        if (hash[i][M] != 0) return hash[i][M];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            min = Math.min(min, helper(a, i + x, Math.max(M, x)));
        }

        hash[i][M] = sums[i] - min;
        return hash[i][M];
    }

    @Test
    public void test1() {
        Assert.assertEquals(Solution.stoneGameII(new int[]{2,7,9,4,4}), 10);
    }
}