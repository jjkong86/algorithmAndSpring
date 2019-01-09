package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10844 {
	private static final int divide = 1000000000;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	//n = 1 -> 1,2,3,4,5 .... 
    	//n = 2 -> 10, 12, 21, 23, 32, 34 ....
    	//n의 계단 수는 n-1일때 +1, -1 일때 성립함
    	//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[][] count = new int[101][10];
        
        for (int i = 1; i < 10; i++) {
			count[1][i] = 1;
		}
        
        for (int i = 2; i <= number; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					count[i][0] = count[i - 1][1] % divide;
				} else if (j == 9) {
					count[i][9] = count[i - 1][8] % divide;
				} else {
					count[i][j] = (count[i - 1][j - 1] + count[i - 1][j + 1]) % divide;
				}
			}
		}
        int result = 0;
        for (int i = 0; i < 10; i++) {
			result = (result+count[number][i]) % divide;
		}
        System.out.println(result);
	}
}