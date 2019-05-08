package etc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {
	
	public static void main(String[] args) {
		String str = "532";
		char[] c = str.toCharArray();
		System.out.println(Integer.parseInt(new String(c)));
		
		Map<String, Integer> map = new HashMap<>();
		char[] array = Arrays.copyOf(c, 3);
	}
	
	public static void primerize(int[][] array, int num) {
        int cal = num;
        int twoCount = 0, fiveCount = 0;
        while (cal > 1) {
            if (array[cal][0] != 0 || array[cal][1] != 0) { //캐싱을 위해
                twoCount += array[cal][0];
                fiveCount += array[cal][1];
                break;
            }
            if (cal % 2 == 0) {
                cal /= 2;
                twoCount++;
            } else if (cal % 5 == 0) {
                cal /= 5;
                fiveCount++;
            } else {
                break;
            }
        }
        array[num][0] = twoCount;
        array[num][1] = fiveCount;
    }
	
}
