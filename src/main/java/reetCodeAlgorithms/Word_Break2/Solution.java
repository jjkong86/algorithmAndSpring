package reetCodeAlgorithms.Word_Break2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp로 문제 풀어야함
        // 값을 찾는거라 set 이용하면 될듯
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
//                	System.out.println(s.substring(j, i));
                	List<String> saveList = map.get(i);
                	List<String> temp = map.get(j);
                	StringBuilder sb = new StringBuilder();
                	sb.append(s.substring(j, i));
                	if (j != 0) {
                		for (int k = 0; k < temp.size(); k++) {
							StringBuilder sbSave = new StringBuilder();
							sbSave.append(temp.get(k) + " ").append(sb);
							saveList.add(sbSave.toString());
						}
                		
                	} else {
                		saveList.add(sb.toString());
                	}
                    map.put(i, saveList);
                }
            }
        }
        System.out.println(map.get(len).toString());
		return map.get(len);
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
    	
    	@Test
    	public void test2() {
    		assertThat(
				new ArrayList<>(Arrays.asList(new String[] {})), 
				is(s.wordBreak("catsandog", 
					new ArrayList<>(Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"})))));
    	}
    	
    	@Test
    	public void test3() {
    		assertThat(
				new ArrayList<>(Arrays.asList(new String[] {"pine apple pen apple", "pineapple pen apple", "pine applepen apple"})), 
				is(s.wordBreak("pineapplepenapple", 
					new ArrayList<>(Arrays.asList(new String[] {"apple", "pen", "applepen", "pine", "pineapple"})))));
    	}
    }
}
