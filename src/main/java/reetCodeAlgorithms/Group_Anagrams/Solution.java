package reetCodeAlgorithms.Group_Anagrams;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.Test;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	
    	if (strs.length == 1) {
    		List<List<String>> list = new ArrayList<>();
    		List<String> tempList = new ArrayList<>();
    		tempList.add(strs[0]);
    		list.add(tempList);
    		return list;
        }
    	
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        List<List<String>> res = new ArrayList<>();
        
        for (int i=0; i<strs.length; i++) {
            if (!set.contains(strs[i])) continue;
            List<String> tempList = new ArrayList<>(findAnagrams(new HashSet<String>(), set, strs[i], ""));
            if (!tempList.isEmpty()) {
            	Collections.sort(tempList);
                res.add(tempList);
            }
        }
        Collections.sort(res, new Comparator<List<String>>() {
        	@Override
        	public int compare(List<String> o1, List<String> o2) {
        		return Integer.compare(o1.size(), o2.size());
        	}
		});
        System.out.println(res.toString());
        return res;
    }
    
    public Set<String> findAnagrams(Set<String> tempSet, Set<String> set, String str, String save) {
        if (str.length() == 0 || set.size() == 0) {
        	if (set.contains(save)) {
        		tempSet.add(save);
        		set.remove(save);
        	}
    		return tempSet;
        }
        
        for (int i=0; i<str.length(); i++) {
            tempSet = findAnagrams(tempSet, set, substractStr(str, i), String.valueOf(str.charAt(i))+save);
        }
        return tempSet;
    }
    
    public String substractStr(String str, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, index)).append(str.substring(index+1, str.length()));
        return sb.toString();
    }
    
    public static class TestClass {
    	
    	@Test
    	public void test1() {
    		Solution s = new Solution();
    		assertThat("[[ate, tea, eat], [nat, tan], [bat]]",  
    				is(s.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})));
    	}
    	
//    	@Test
//    	public void test2() {
//    		Solution s = new Solution();
//    		assertThat("[[,]]",  
//    				is(s.groupAnagrams(new String[] {"", ""})));
//    	}
    }
    
}
