package codewars.Sum_of_Digits_Digital_Root;

import java.util.stream.IntStream;

public class DRoot {
	public static int digital_root(int n) {
		// long type 고려 필요한듯
		if (n == 0) return 0;
		while (n >= 10) {
			String[] split = String.valueOf(n).split("");
			int[] array = new int[split.length];
			IntStream.range(0, split.length).forEach(i -> array[i] = Integer.parseInt(split[i]));
			Integer tempSum = IntStream.of(array).sum();
			n = tempSum;
		}
		return n;
	}

	public static int digital_root2(int n) {
		while (n > 9) {
			n = n / 10 + n % 10;
		}
		return (n);
	}
}
