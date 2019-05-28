package reetCodeAlgorithms.Word_Break2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp로 문제 풀어야함
        // 값을 찾는거라 set 이용하면 될듯
    	System.out.println(s);
        List<String> res = new ArrayList<>();
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i=0; i<=len; i++) {
            List<String> list = new ArrayList<>();
            if (i == 0) {
                list.add("first");
            }
            map.put(i, list);
        }
        
        for (int i=1; i<=len; i++) {
            for (int j=0; j<i; j++) {
                if (!map.get(j).isEmpty() && dict.contains(s.substring(j, i))) {
                	System.out.println(s.substring(j, i));
                	List<String> temp = map.get(i);
                	temp.add(s.substring(j, i));
                    map.put(i, temp);
                }
            }
        }
        
        for (int i=0; i<map.size(); i++) {
            List<String> temp = map.get(i);
            while(!temp.isEmpty()) {
                
            }
        }
        System.out.println(res.toString());
		return res;
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(
				new ArrayList<>(Arrays.asList(new String[] {"cats and dog", "cat sand dog"})), 
				is(s.wordBreak("catsanddog", 
					new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"})))));
    	}
    }
}
