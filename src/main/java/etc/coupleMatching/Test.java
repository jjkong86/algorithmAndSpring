package etc.coupleMatching;

import java.util.HashMap;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class Test {
	public static void main(String[] args) {
		System.out.println(FuzzySearch.ratio("mysmilarstring","myawfullysimilarstirng"));
		String aa = "aa";
		System.out.println(aa);
		aa = "bb";
		System.out.println(aa);
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "aa");
		map.get("a");
	}
}
