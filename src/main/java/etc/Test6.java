package etc;

import java.util.stream.Stream;

public class Test6 {
	public static void main(String[] args) {
        int num = 78;
        String bi = Integer.toBinaryString(num);
        long count = Stream.of(bi.split("")).filter(i -> i.equals("1")).count();
        System.out.println(count);
        
        
        String str = "abc";
        System.out.println(str.toUpperCase());
        
        String str1 = "a b ";
        System.out.println(str1.length());
        String res = "A B";
        for (int i=str1.length()-1; i>=0; i--) {
            if (str1.substring(i, i+1).equals(" ")) res+=" ";
            else break;
        }
        System.out.println(res);
        String test1 = "1234567";
        System.out.println(test1.substring(0, 2) + test1.substring(3));
	}
}
