package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Number1003 {
    
    public static void main(String[] a) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] saveArray = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
			saveArray[i] = Integer.parseInt(br.readLine());
			if (saveArray[i] > max) {
				max = saveArray[i];
			}
		}
        int[][] array = new int[max+1][2];
        for (int i = 0; i <= max; i++) {
        	if (i == 0) {
        		array[i][0] = 1;
                array[i][1] = 0;
			} else if (i == 1) {
				array[i][0] = 0;
		        array[i][1] = 1;
			} else {
				array[i][0] = array[i-1][0]+array[i-2][0];
				array[i][1] = array[i-1][1] + array[i-2][1];
			}
		}
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
        	sb.setLength(0);
			sj.add(sb.append(array[saveArray[i]][0]).append(" ").append(array[saveArray[i]][1]));
        }
        System.out.println(sj);
        br.close();
    }
}
