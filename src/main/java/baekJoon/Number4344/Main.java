package baekJoon.Number4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            String input = br.readLine();
            String ret = String.valueOf(avgRatio(input));
            String[] split = ret.split(".");
            if (split[1].length() != 4) {
				for (int j = split[1].length()-1; j < 4; j++) {
					
				}
			}
            sb.append(avgRatio(input)+"\n");
        }
        System.out.println(sb);
        br.close();
    }
    public static double avgRatio(String str) {
    	String[] strArray = str.split(" ");
    	double num = Integer.parseInt(strArray[0]);
    	int[] array = new int[(int) num];
    	int sum = 0;
    	for (int i = 1; i < strArray.length; i++) {
			array[i-1] = Integer.parseInt(strArray[i]);
			sum += array[i-1];
		}
        double avg = sum/num;
        Arrays.sort(array);
        double count = 0;
        for (int i = array.length-1; i >= 0; i--) {
			if (array[i] > avg) {
				count ++;
			} else {
				break;
			}
		}
        
        double ratio = Math.round((count/num) * 100 * 1000);
        return ratio / 1000;
    }
}
