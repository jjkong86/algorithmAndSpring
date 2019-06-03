package reetCodeAlgorithms.Group_Anagrams;

import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        List<List<String>> res = new ArrayList<>();
        
        for (int i=0; i<set.size(); i++) {
            if (!set.contains(strs[i])) continue;
            List<String> tempList = findAnagrams(new ArrayList<String>(), set, strs[i], "");
            if (!tempList.isEmpty()) {
                res.add(tempList);
            }
        }
        return res;
    }
    
    public List<String> findAnagrams(List<String> tempList, Set<String> set, String str, String save) {
        if (str.length() == 0 && set.contains(save)) {
            tempList.add(save);
            set.remove(save);
            return tempList;
        }
        
        for (int i=0; i<str.length(); i++) {
            String temp = str.substring(i, i+1);
            str = substractStr(str, i);
            tempList = findAnagrams(tempList, set, str, temp+save);
        }
        return tempList;
    }
    
    public String substractStr(String str, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, index)).append(str.substring(index));
        return sb.toString();
    }
    
}
