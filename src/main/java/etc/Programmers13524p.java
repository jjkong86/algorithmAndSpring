package etc;

import java.util.*;
class Programmers13524p {
    public int solution(int[] w) {
        // 정렬해서 찾아볼까?
        if (w.length == 1) return w[0]+1;
        Map<Integer, Integer> map = new HashMap<>();
        String str = "";
        for (int num : w) {
        	str+=num;
        }
        makeWeight(map, str, 0);
        
        
        int res = 0;
        return res;
    }
    
    private void makeWeight(Map<Integer, Integer> map, String w, int sum) {
        if (w.length() == 1) return;
        for (int i=0; i<w.length(); i++) {
            sum += Character.getNumericValue(w.charAt(i));
            map.put(sum, sum);
            String str = makeStr(w, i);
            makeWeight(map, str, sum);
        }
    }
    
    private String makeStr(String w, int index) {
        String res = "";
        if (index == 0) {
            res = w.substring(index+1);
        } else {
            res = w.substring(0, index) + w.substring(index+1);
        }
        return res;
    }
}
