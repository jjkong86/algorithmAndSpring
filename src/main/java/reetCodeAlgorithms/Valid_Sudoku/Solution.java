package reetCodeAlgorithms.Valid_Sudoku;

import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 가로, 세로, 3*3 중복 숫자가 나오면 안됨 (1 ~ 9)
        int len = board.length;
        for (int i=0; i<len; i++) {
            Set<Character> setHorizontal = new HashSet<>();
            int countHorizontal = 0;
            
            Set<Character> setVertical = new HashSet<>();
            int countVertical = 0;
            
            Set<Character> setThree = new HashSet<>();
            int countThree = 0;
            
            for (int j=0; j<len; j++) {
                if (board[i][j] != '.') {
                    setHorizontal.add(board[i][j]);
                    countHorizontal++;
                }
                if (board[j][i] != '.') {
                    setVertical.add(board[j][i]);
                    countVertical++;
                }
                int index = i + j/3;
                j = j%3;
                if (board[index][j] != '.') {
                    setThree.add(board[index][j]);
                    countThree++;
                }
            }
            
            if (setHorizontal.size() != countHorizontal || setVertical.size() != countVertical || setThree.size() != countThree) {
                return false;
            }
        }
        
        return true;
    }
}
