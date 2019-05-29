package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test6 {
	public static void main(String[] args) {
		
		String s = "applepenapple";
		
		StringBuilder sb = new StringBuilder();
		String word = "applepenapple";
		int index = s.indexOf(word);
        sb.append(s.substring(0, index));
        sb.append(s.substring(index+word.length(), s.length()));
        System.out.println(sb);
        
        String temp = "123456711";
        System.out.println(temp.indexOf("1", 0));
        
        Map<Integer, List<String>> saveMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("abc");
        saveMap.put(1, list);
        saveMap.put(2, null);
        if (saveMap.get(1) != null) {
        	System.out.println("1 not null");
        }
        if (saveMap.get(2) != null) {
        	System.out.println("2 not null");
        }
        
        
	}
}
