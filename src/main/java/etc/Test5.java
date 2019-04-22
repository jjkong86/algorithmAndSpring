package etc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {
	
	public static void main(String[] args) {
		String str = "0x4417626b2576a783c11f49d3fb1cb6c1f424a9d1c3ec09daeb6cd03a7471a642";
		System.out.println(str.replace("0x", "").startsWith("00"));
		int[] array = new int[5];
		
		Arrays.fill(array, 5);
		
		System.out.println(new BigInteger("0x5208".replaceAll("0x", ""), 16));
		
	}
	
}
