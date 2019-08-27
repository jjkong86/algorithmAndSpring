package reetCodeAlgorithms.PermutationsII;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Solution2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        System.out.println(res.toString());
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
	
	public static class TestClass {
		Solution2 s = new Solution2();
		List<List<Integer>> list = new ArrayList<>();
		@Test
		public void test1() {
			assertThat(list, is(s.permuteUnique(new int[] {1,1,2})));
		}
		
		@Test
		public void test2() {
			assertThat(list, is(s.permuteUnique(new int[] {1,2,3})));
		}
		
		@Test
		public void test3() {
			assertThat(list, is(s.permuteUnique(new int[] {1,1,1,1})));
		}
		
		@Test
		public void test4() {
			assertThat(list, is(s.permuteUnique(new int[] {1,-1,-4})));
		}
	}
}
