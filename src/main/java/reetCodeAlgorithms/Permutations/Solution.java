package reetCodeAlgorithms.Permutations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.*;

import org.junit.Test;

import junit.framework.Assert;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 순열
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 0) return res;
        if (nums.length == 1) {
            res.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[0]})));
            return res;
        }
        List<Integer> convert = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        makePermute(res, convert, new ArrayList<>());
        Collections.sort(res, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i) == o2.get(i)) continue;
					else return Integer.compare(o1.get(i), o2.get(i));
				}
				return 0;
			}
		});
        System.out.println(res.toString());
        return res;
    }
    
    private List<List<Integer>> makePermute(List<List<Integer>> list, List<Integer> convert, List<Integer> save) {
        if (convert.isEmpty()) {
            list.add(save);
            return list;
        }
        
        for (int i=0; i<convert.size(); i++) {
        	List<Integer> convertCopy = convert.stream().collect(Collectors.toList());
        	List<Integer> convertsava = save.stream().collect(Collectors.toList());
        	convertsava.add(convert.get(i));
        	convertCopy.remove(i);
            list = makePermute(list, convertCopy, convertsava);
        }
        return list;
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
    		Assert.assertEquals(list, s.permute(new int[] {0,-1,1}));
    	}
    }
    
}
