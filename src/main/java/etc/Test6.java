package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Test6 {
	public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        Integer[] array = new Integer[] {1,2,3};
        List<Integer> arraytoList = Arrays.asList(array);
        ArrayList<Integer> subList = new ArrayList<>(Arrays.asList(array));
        List<String> linked = new LinkedList<>(Arrays.asList("a b c".split(" ")));
        list1.add(new ArrayList<>(Arrays.asList(array)));
        
        Map<String, List<String>> map = new HashMap<>();
        map.put("123", linked);
        List<List<String>> list2 = new ArrayList<>(map.values());
        String str = "12123345";
        System.out.println(str.substring(0, 1));
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
        
        
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        Map<String, String> map213 = new HashMap<>();
        map213.put("abc", "aaaa");
        List<String> list123 = new ArrayList<>(map213.keySet());
        Map<String, String> map2135 = new LinkedHashMap<>();
        
	}
}
