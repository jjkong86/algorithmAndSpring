package reetCodeAlgorithms.Friend_Circles;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


class Solution {
    // 간접, 혹은 직접 친구의 그룹 수
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int findCircleNum(int[][] m) {
        if (m == null || m[0] == null)
            return 0;

        int ver = m.length, ho = m[0].length;
        for (int i = 0; i < ver; i++) {

            for (int j = 0; j < ho; j++) {
                if (i == j)  // 해당 숫자의 좌표는 항상 1
                    continue;

                if (m[i][j] == 1 && m[j][i] == 1) {
                    this.dateSet(i, j);
                } else {
                    this.dateSet(j);
                }
            }
        }
        System.out.println(map);

        return map.size();
    }

    public void dateSet(Integer... values) {
        boolean remove = false;
        Set<Integer> resultSet = map.values().stream()
                .filter(set -> this.arrayContains(set, values)).findFirst().orElseGet(HashSet::new);

        remove = (resultSet.size() == 0);
        if (remove) {
            map.put(Arrays.stream(values).mapToInt(i -> i).min().orElseThrow(NoSuchElementException::new), resultSet);
        }

        resultSet.addAll(Arrays.asList(values));
        System.out.println(map);
        if (!remove) {
            for (Integer value : values) {
                Set<Integer> temp = map.get(value);
                if (temp != null && temp != resultSet) {
                    map.remove(value);
                    System.out.println(map);
                }
            }
        }
    }

    public boolean arrayContains(Set<Integer> set, Integer[] values) {
        return Arrays.stream(values).anyMatch(set::contains);
    }

    public static class TestClass {
        Solution s = new Solution();

        @Test
        public void test1() {
            int[][] array = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
            Assert.assertEquals(s.findCircleNum(array), 2);
        }

        @Test
        public void test2() {
            int[][] array = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
            Assert.assertEquals(s.findCircleNum(array), 1);
        }

    }
}
