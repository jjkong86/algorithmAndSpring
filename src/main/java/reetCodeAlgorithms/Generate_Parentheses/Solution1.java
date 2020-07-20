package reetCodeAlgorithms.Generate_Parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    private final String LEFT = "(";
    private final String RIGHT = ")";
    private List<String> list = new ArrayList<>();
    private int number = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return new ArrayList<>(Collections.singletonList(""));

        number = n;
        this.setStr("", 0, 0);
        return list;
    }

    private void setStr(String str, int leftCount, int rightCount) {
        if (str.length() >= number * 2) {
            list.add(str);
            return;
        }

        if (leftCount < number)
            setStr(str + LEFT, leftCount + 1, rightCount);

        if (rightCount < leftCount)
            setStr(str + RIGHT, leftCount, rightCount + 1);
    }

}
