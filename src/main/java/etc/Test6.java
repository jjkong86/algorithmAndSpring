package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	}
}
