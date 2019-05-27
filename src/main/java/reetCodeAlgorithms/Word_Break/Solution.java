package reetCodeAlgorithms.Word_Break;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 문자열 s가 주어지면 wordDict의 단어들이 포함되는가?
        // 사용된 문자열은 다시 사용될 수 없음, 사전은 가능함.
        
    	if (wordDict.size() < 1) return false;
    	
        for (int i=0; i<wordDict.size(); i++) {
        	String temp = s;
        	int count = 0;
        	int indexCount = 0;
        	int[] indexes = new int[s.length()];
        	for (int j = i; j < wordDict.size(); j++) {
	            int index = temp.indexOf(wordDict.get(j));
	            indexes[indexCount] = index;
	            while (index < 0 && indexCount < s.length()) {
	            	index = temp.indexOf(wordDict.get(j), indexes[++indexCount]+1);
	            }
	            
	            if (index >= 0) {
	            	temp = wordSeparation(temp, index, wordDict.get(j));
	                if (temp.replace(",", "").length() == 0) return true;
	                count ++;
	                j--;
	            }
        	}
        	if (count == 0) return false;
        }
        
        return false;
    }
    
    public String wordSeparation(String s, int index, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, index));
        sb.append(",");
        sb.append(s.substring(index+word.length(), s.length()));
        return sb.toString();
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(false, is(s.wordBreak("catsandog", Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"}))));
    		assertThat(true, is(s.wordBreak("bb", Arrays.asList(new String[] {"a","b","bbb","bbbb"}))));
    	}
    	
    	@Test
    	public void test2() {
    		assertThat(true, is(s.wordBreak("cars", Arrays.asList(new String[] {"car","ca","rs"}))));
    		assertThat(false, is(s.wordBreak("ccbb", Arrays.asList(new String[] {"bc","cb"}))));
    		assertThat(true, is(s.wordBreak("ccaccc", Arrays.asList(new String[] {"cc","ac"}))));
    	}
    }
}
