package baekJoon;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Number11021 {
    
    public static void main(String[] a) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringJoiner sj = new StringJoiner("\n");
        for (int i=0; i<len; i++) {
        	sj.add("Case #"+(i+1)+": "+String.valueOf(Stream.of(br.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).sum()));
        }
        System.out.println(sj);
        br.close();
    }
}

