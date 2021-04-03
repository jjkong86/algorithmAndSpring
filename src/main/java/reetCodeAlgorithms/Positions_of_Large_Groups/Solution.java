package reetCodeAlgorithms.Positions_of_Large_Groups;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//A group is considered large if it has 3 or more characters.
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.equals(""))
            return result;

        int length = s.length(), count = 0;
        char save = '\0';

        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (save != temp) {
                this.addResult(count, i - count, i - 1);

                save = temp;
                count = 1;
                continue;
            }

            count++;

            if (isLast(i, length)) {
                this.addResult(count, i - count + 1, i);
            }

        }

        return result;
    }

    public void addResult(int count, int left, int right) {
        if (this.isLarge(count))
            result.add(new ArrayList<>(Arrays.asList(left, right)));
    }


    public boolean isLarge(int count) {
        int large = 3;
        return count >= large;
    }

    private boolean isLast(int i, int length) {
        return length - 1 <= i;
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        assertEquals(s.largeGroupPositions("abbxxxxzzyyy"),
                Arrays.asList(new ArrayList<>(Arrays.asList(3, 6)), Arrays.asList(9, 11)));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        assertEquals(s.largeGroupPositions("abc"),
                new ArrayList<>(new ArrayList<>()));
    }
}
