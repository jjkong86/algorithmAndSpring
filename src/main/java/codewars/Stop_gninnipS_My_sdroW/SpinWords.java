package codewars.Stop_gninnipS_My_sdroW;

import java.util.*;
import java.util.stream.*;

public class SpinWords {

	public String spinWords(String sentence) {
		// TODO: Code stuff here
		// 문자중 5자 이상은 반대로 되어있음
		String[] split = sentence.split(" ");
		return Stream.of(split).map(i -> i.length() >= 5 ? new StringBuilder(i).reverse().toString() : i).collect(Collectors.joining(" "));
	}
}
