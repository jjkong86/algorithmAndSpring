package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test6 {
	public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        Integer[] array = new Integer[] {1,2,3};
        List<Integer> arraytoList = Arrays.asList(array);
        ArrayList<Integer> subList = new ArrayList<>(Arrays.asList(array));
        list1.add(new ArrayList<>(Arrays.asList(array)));
        
        String str = "12345";
        System.out.println(str.substring(2));
	}
}
