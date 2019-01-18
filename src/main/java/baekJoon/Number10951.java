package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number10951 {
    
    public static void main(String[] a) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");
        outerloop : while (true) {
        	String input = br.readLine();
        	if (input == null) {
				break;
			}
        	String[] split = input.split(" ");
        	int sum = 0;
        	for (int i = 0; i < split.length; i++) {
        		int temp = Integer.parseInt(split[i]);
				if (temp < 1 || temp > 9) {
					break outerloop;
				}
				sum += temp; 
			}
        	sj.add(String.valueOf(sum));
        }
        System.out.println(sj);
        br.close();
    }
    
}
