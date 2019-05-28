package etc;

import java.util.Objects;

public class Test6 {
	public static void main(String[] args) {
		
		String s = "applepenapple";
		
		StringBuilder sb = new StringBuilder();
		String word = "applepenapple";
		int index = s.indexOf(word);
        sb.append(s.substring(0, index));
        sb.append(s.substring(index+word.length(), s.length()));
        System.out.println(sb);
        
        String temp = "123456711";
        System.out.println(temp.indexOf("1", 0));
        
        String amount = "0.000009";
        System.out.println(Double.parseDouble(amount));
        
	}
}
