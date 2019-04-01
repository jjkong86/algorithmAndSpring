package codewars.Simple_Pig_Latin;

import java.util.stream.*;

public class PigLatin {
    public static String pigIt(String s) {
        // Write code here
    	return Stream.of(s.split(" "))
    			.map(str -> str.length() > 1 || Character.isLetter(str.charAt(0)) ? str.substring(1) + str.charAt(0) + "ay" : str)
    			.collect(Collectors.joining(" "));
    }
}
