package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10824 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// 범위 1 ~ 1,000,000 -> 두수를 붙이면 10^6 * 10^6
		// 더블로 해야할듯?
		// System.out.println(Math.pow(10, 12) > Integer.MAX_VALUE ? Math.pow(10, 12) > Double.MAX_VALUE ? "double < x" : "int < x < double" : "int > x")
		// result : int < x < double
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		System.out.println(Long.parseLong(split[0]+split[1])+Long.parseLong(split[2]+split[3]));
	}

}
