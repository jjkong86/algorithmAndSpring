package baekJoon.Number13235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


class Main {
    public static boolean chkPalindrome(String str) {
        if (Objects.requireNonNull(str) == null) return false;
        int len = str.length();
        for (int i=0; i<len; i++) {
            if (str.charAt(i) != str.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            System.out.println(chkPalindrome(str));
        }
    }
}
