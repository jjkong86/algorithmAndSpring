package reetCodeAlgorithms.Flood_Fill;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class Solution {
    int[][] coors = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    boolean[][] isCheck;
    int newColor;

    private static class Coordinate {
        int ho;
        int ver;

        Coordinate(int ho, int ver) {
            this.ho = ho;
            this.ver = ver;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0)
            return image;

        this.newColor = newColor;
        int hoLength = image.length, verLength = image[0].length;
        isCheck = new boolean[hoLength][verLength];
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(sr, sc));

        while (!stack.isEmpty()) {
            Coordinate curr = stack.pop();
            applyAndPushCoordinate(image, stack, curr); //적용 가능한 좌표 찾고(이미 적용된 좌표는 제외) 적용시키고 스택에 넣음
        }

        return image;
    }

    private void applyAndPushCoordinate(int[][] image, Stack<Coordinate> stack, Coordinate curr) {
        for (int[] co : coors) {
            int ho = curr.ho + co[0], ver = curr.ver + co[1];
            if (outOfIndexCheck(image, ho, ver)) {
                image[ho][ver] = newColor;
                isCheck[ho][ver] = true;
                stack.push(new Coordinate(ho, ver));
            }
        }
    }

    private boolean outOfIndexCheck(int[][] image, int ho, int ver) {
        return ho >= 0 && ho < isCheck.length && ver >= 0 && ver < isCheck[0].length && !isCheck[ho][ver] && image[ho][ver] != newColor;
    }

    public static class TestClass {
        @Test
        public void test1() {
            Solution s = new Solution();
            Assert.assertSame(s.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2), new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}});
        }
    }
}
