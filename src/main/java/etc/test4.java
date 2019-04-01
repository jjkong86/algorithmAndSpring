package etc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test4 {
	public static void main(String[] args) {
		String a = "1 2 3456";
		System.out.println(a.substring(0));
		System.out.println(a.substring(0, 1));
		System.out.println(Stream.of(a.split(" ")).map(str -> str).collect(Collectors.joining(" ")));
		System.out.println(Character.isLetter(a.charAt(0)));
	}
}
