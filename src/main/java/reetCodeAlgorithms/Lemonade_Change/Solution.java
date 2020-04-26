package reetCodeAlgorithms.Lemonade_Change;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {
    final int FIVE = 5;

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int bill : bills) {
            map.put(bill, map.getOrDefault(bill, 0) + 1);
            if (bill > FIVE) {
                if (!calculateChange(map, bill - FIVE))
                    return false;
            }

            System.out.println(map.toString());
        }

        return true;
    }

    private boolean calculateChange(Map<Integer, Integer> map, int change) {
        int num = change;
        while (num > 0 && change >= 0) {
            if (map.get(change) != null && map.get(change) > 0 && num >= change) {
                map.put(change, map.get(change) - 1);
                num -= change;
            } else {
                change -= FIVE;
            }
        }
        return num == 0;
    }

    public static class TestClass {
        Solution s = new Solution();

        @Test
        public void test1() {
            Assert.assertTrue(s.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        }

        @Test
        public void test2() {
            Assert.assertTrue(s.lemonadeChange(new int[]{5,5,5,5,10,5,10,10,10,20}));
        }

    }
}
