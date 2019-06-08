package reetCodeAlgorithms.Group_Anagrams;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
public class Solution2 {
	
	
	public List<List<String>> groupAnagrams(String[] strs) {
		//각 항목을 정렬하여 찾아보자
        
        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, Integer> sortBySize = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sort = String.valueOf(chars);
            if (!map.containsKey(sort)) {
                map.put(sort, new ArrayList<String>());
                sortBySize.put(sort, 0);
            }
            map.get(sort).add(str);
            sortBySize.put(sort, sortBySize.get(sort)+1);
        }
        
        List<Entry<String, Integer>> list = new ArrayList<>(sortBySize.entrySet());
        list.sort(Entry.comparingByValue()); // value size에 따라 정렬
        
        Map<String, List<String>> sorMap = sortByKeyAndValues(map, list);
        List<List<String>> res = new ArrayList<>(sorMap.values());
        System.out.println(res.toString());
		return res;
    }
	
	private Map<String, List<String>> sortByKeyAndValues(Map<String, List<String>> map, List<Entry<String, Integer>> list) {
		Map<String, List<String>> sortMap = new LinkedHashMap<>();
		
		for (int i=0; i<list.size(); i++) {
			List<String> tempList = map.get(list.get(i).getKey());
			Collections.sort(tempList);
			sortMap.put(list.get(i).getKey(), tempList);
		}
		return sortMap;
	}
	
	
	
public static class TestClass {
    	
    	@Test
    	public void test1() {
    		Solution2 s = new Solution2();
    		assertThat("[[ate, tea, eat], [nat, tan], [bat]]",  
    				is(s.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})));
    	}
    	
    	@Test
    	public void test2() {
    		Solution s = new Solution();
    		assertThat("[[],[]]",  
    				is(s.groupAnagrams(new String[] {"", ""})));
    	}
    }
}
