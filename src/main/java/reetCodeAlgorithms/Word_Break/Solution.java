package reetCodeAlgorithms.Word_Break;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 문자열 s가 주어지면 wordDict의 단어들이 포함되는가?
        // 사용된 문자열은 다시 사용될 수 없음, 사전은 가능함.
    	System.out.println("========================");
        System.out.println(s);
        System.out.println(wordDict.toString());
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        Set<String> dict = new HashSet<>(wordDict);
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
            	System.out.println("i : "+i + " -> "+s.substring(j, i));
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    System.out.println("i : "+i+", j : "+j+" : true");
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
    
    public static class TestClass {
    	Solution s = new Solution();
    	@Test
    	public void test1() {
    		assertThat(true, is(s.wordBreak("leetcode", Arrays.asList(new String[] {"leet", "code"}))));
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
