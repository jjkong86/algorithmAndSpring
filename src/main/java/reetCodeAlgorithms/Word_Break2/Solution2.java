package reetCodeAlgorithms.Word_Break2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Solution2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
	    return DFS(s, new HashSet<>(wordDict), new HashMap<String, LinkedList<String>>());
	}       

	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String> res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }
	    
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }
	    map.put(s, res);
	    System.out.println(res.toString());
	    return res;
	}
	
	public static class TestClass {
    	Solution2 s = new Solution2();
    	@Test
    	public void test1() {
    		assertThat(
				new ArrayList<>(Arrays.asList(new String[] {"cats and dog", "cat sand dog"})), 
				is(s.wordBreak("catsanddog", 
					new ArrayList<>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"})))));
    	}
    	
//    	@Test
//    	public void test2() {
//    		assertThat(
//				new ArrayList<>(Arrays.asList(new String[] {})), 
//				is(s.wordBreak("catsandog", 
//					new ArrayList<>(Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat", "an"})))));
//    	}
    	
    	@Test
    	public void test3() {
    		assertThat(
				new ArrayList<>(Arrays.asList(new String[] {"pine apple pen apple", "pineapple pen apple", "pine applepen apple"})), 
				is(s.wordBreak("pineapplepenapple", 
					new ArrayList<>(Arrays.asList(new String[] {"apple", "pen", "applepen", "pine", "pineapple"})))));
    	}
    }
}
