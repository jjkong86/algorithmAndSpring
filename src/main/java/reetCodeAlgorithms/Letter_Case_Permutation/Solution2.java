package reetCodeAlgorithms.Letter_Case_Permutation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;

class Solution2 {
	public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
    
    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }
        
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }
	
	public static class TesetClass {
		Solution2 s = new Solution2();
		@Test
		public void test1() {
			assertThat(Arrays.asList(new String[] {"a1b2", "a1B2", "A1b2", "A1B2"}), is(s.letterCasePermutation("a1b2")));
		}
		
		@Test
		public void test2() {
			assertThat(Arrays.asList(new String[] {"3z4", "3Z4"}), is(s.letterCasePermutation("3z4")));
		}
		
		@Test
		public void test3() {
			assertThat(Arrays.asList(new String[] {"12345"}), is(s.letterCasePermutation("12345")));
		}
	}
}
