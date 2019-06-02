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
        Arrays.sort(nums);
        makePermute(res, new ArrayList<>(), nums);
        System.out.println(res.toString());
        return res;
    }
    
    private void makePermute(List<List<Integer>> list, List<Integer> tempList, int [] nums){
    	   if(tempList.size() == nums.length){
    	      list.add(new ArrayList<>(tempList));
    	   } else{
    	      for(int i = 0; i < nums.length; i++){ 
    	         if(tempList.contains(nums[i])) continue; // 중복 체크
    	         tempList.add(nums[i]);
    	         makePermute(list, tempList, nums);
    	         tempList.remove(tempList.size() - 1);
    	      }
    	   }
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
