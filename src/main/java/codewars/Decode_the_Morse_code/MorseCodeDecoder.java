package codewars.Decode_the_Morse_code;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        StringBuilder sb = new StringBuilder();
        String[] word = morseCode.split("   ");
        for (int i=0; i<word.length; i++) {
          String[] character = word[i].split(" ");
          
          for (int j=0; j<character.length; j++) {
            sb.append(MorseCode.get(character(j)));
          }
          sb.append(" ");
        }
        return sb.toString();
    }
}
