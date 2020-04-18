package programmers.크레인_인형뽑기_게임;


// https://programmers.co.kr/learn/courses/30/lessons/64061

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int answer = 0, length = board.length;
        int[] coor = new int[moves.length];

        for (int index : moves) {
            index--;
            //System.out.println("index : " + index);
            for (int i = coor[index]; i < length; i++) {
                int target = board[i][index];
                if (target == 0)
                    continue;

                board[i][index] = 0;
                coor[index] = i; // board판에서 각 배열마다 가장 앞에 있는 숫자 저장용

                if (!s.empty() && s.lastElement() == target) {
                    s.pop();
                    answer++;
                } else {
                    s.push(target);
                }

                //System.out.println("stack print : " + s.toString());
                break;
            }
        }

        return answer * 2;
    }

    public static class TestClass {

        @Test
        public void test1() {
            assertEquals(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                    new int[]{1, 5, 3, 5, 1, 2, 1, 4}), 4);
        }
    }
}
