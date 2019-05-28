package etc;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.toString());
		}
	}
}
