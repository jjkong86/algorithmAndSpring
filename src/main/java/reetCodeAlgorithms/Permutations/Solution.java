package reetCodeAlgorithms.Permutations;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 순열
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(new ArrayList<>(Collections.singletonList(nums[0])));
            return res;
        }
        List<Integer> convert = Arrays.stream(nums).boxed().collect(Collectors.toList());

        makePermute(res, convert, new ArrayList<>());
        res.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i)))
                    return Integer.compare(o1.get(i), o2.get(i));
            }
            return 0;
        });
        System.out.println(res.toString());
        return res;
    }

    private void makePermute(List<List<Integer>> list, List<Integer> convert, List<Integer> save) {
        if (convert.isEmpty()) {
            list.add(save);
            return;
        }

        for (int i = 0; i < convert.size(); i++) {
            List<Integer> convertCopy = new ArrayList<>(convert);
            List<Integer> convertSave = new ArrayList<>(save);
            convertSave.add(convert.get(i));
            convertCopy.remove(i);
            makePermute(list, convertCopy, convertSave);
        }
    }

    public static class TestClass {
        Solution s = new Solution();
        List<List<Integer>> list = new ArrayList<>();

//    	@Test
//    	public void test1() {
//    		Assert.assertEquals(list, s.permute(new int[] {1,2,3}));
//    	}

        @Test
        public void test2() {
            Assert.assertEquals(list, s.permute(new int[]{0, -1, 1}));
        }
    }

}
