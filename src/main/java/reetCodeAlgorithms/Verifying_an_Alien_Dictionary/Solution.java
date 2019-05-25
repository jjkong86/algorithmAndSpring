package reetCodeAlgorithms.Verifying_an_Alien_Dictionary;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Solution {
    public static boolean isAlienSorted(String[] words, String order) {
        // 주어진 order를 기준으로 words가 오름차순으로 정렬하고 words와 비교하면 될듯
        int len = words.length;
        for (int i=0; i<len-1; i++) {
            boolean chk = isSortChk(words[i], words[i+1], order);
            if (!chk) return false;
        }
        return true;
    }
    
    public static boolean isSortChk(String left, String right, String order) {
        int len = Math.min(left.length(), right.length());
        for (int i=0; i<len; i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
//            System.out.println(order.indexOf(l) + "::"+order.indexOf(r));
            if (l == r) continue;
            else if (order.indexOf(l) < order.indexOf(r)) return true;
            else if (order.indexOf(l) > order.indexOf(r)) return false;
        }
        return left.length() <= right.length();
    }
    
    public static class TestClass {
    	
    	@Test
    	public void test1() {
    		assertThat(true, is(isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")));
    	}
    }
}
