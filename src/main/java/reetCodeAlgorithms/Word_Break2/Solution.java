package reetCodeAlgorithms.Word_Break2;

import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp로 문제 풀어야함
        // 값을 찾는거라 set 이용하면 될듯
        List<String> res = new ArrayList<>();
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        String[] save = new String[len+1];
        save[0] = "start";
        for (int i=1; i<=len; i++) {
            for (int j=0; j<i; j++) {
                if (!save[j].equals("") && dict.contains(s.substring(j, i))) {
                    
                }
            }
        }
        
        
		return res;
    }
}
