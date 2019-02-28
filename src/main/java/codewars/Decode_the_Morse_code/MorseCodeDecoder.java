package codewars.Decode_the_Morse_code;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
    	return Stream.of(morseCode.trim().split("   ")).map(i -> decodeWord(i)).collect(Collectors.joining(" "));
    }
    public static String decodeWord(String str) {
//    	return Stream.of(str.trim().split(" ")).map(i -> MorseCode.get(i)).collect(Collectors.joining());
    	return "";
    }
}
