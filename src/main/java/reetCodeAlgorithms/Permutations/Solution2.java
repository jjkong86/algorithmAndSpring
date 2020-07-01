package reetCodeAlgorithms.Permutations;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        // 순열
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(new ArrayList<>(Collections.singletonList(nums[0])));
            return res;
        }

        Arrays.sort(nums);
        makePermute(res, new ArrayList<>(), nums);
        System.out.println(res.toString());
        return res;
    }

    private void makePermute(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) continue; // 중복 체크
            tempList.add(num);
//	         System.out.println(tempList.toString() + ", index :" + i);
            makePermute(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static class TestClass {
        Solution2 s = new Solution2();
        List<List<Integer>> list = new ArrayList<>();

        @Test
        public void test1() {
            Assert.assertEquals(list, s.permute(new int[]{1, 2, 3}));
        }

        @Test
        public void test2() {
            Assert.assertEquals(list, s.permute(new int[]{0, -1, 1}));
        }
    }

}
