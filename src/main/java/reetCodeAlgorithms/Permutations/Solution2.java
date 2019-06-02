package reetCodeAlgorithms.Permutations;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.Assert;
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        // 순열
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 0) return res;
        if (nums.length == 1) {
            res.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[0]})));
            return res;
        }
        List<Integer> convert = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<List<Integer>> setRes = new HashSet<>(); 
        setRes = makePermute(setRes, convert, new ArrayList<>());
        res = new ArrayList<>(setRes);
        System.out.println(res.toString());
        return res;
    }
    
    private Set<List<Integer>> makePermute(Set<List<Integer>> list, List<Integer> convert, List<Integer> save) {
        if (convert.isEmpty()) {
            list.add(new ArrayList<>(save));
            save.clear();
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
    	Solution2 s = new Solution2();
    	List<List<Integer>> list = new ArrayList<>();
    	
    	@Test
    	public void test1() {
    		Assert.assertEquals(list, s.permute(new int[] {1,2,3}));
    	}
    	
    	@Test
    	public void test2() {
    		Assert.assertEquals(list, s.permute(new int[] {0,-1,1}));
    	}
    }
    
}
