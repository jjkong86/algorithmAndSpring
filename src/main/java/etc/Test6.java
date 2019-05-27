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
        
        String temp = s;
        temp = temp.substring(0, 3);
        System.out.println(temp + "::"+s);
	}
}
