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
    	String temp = s;
        for (int i=0; i<wordDict.size(); i++) {
            int index = s.indexOf(wordDict.get(i));
            if (index >= 0) {
                s = wordSeparation(s, index, wordDict.get(i));
                if (s.length() == 0) return true;
                i--;
            }
        }
        
        return false;
    }
    
    public String wordSeparation(String s, int index, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, index));
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
    }
}
