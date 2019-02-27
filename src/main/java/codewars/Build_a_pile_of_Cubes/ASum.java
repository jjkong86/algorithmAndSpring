package codewars.Build_a_pile_of_Cubes;

public class ASum {

	public static long findNb(long m) {
		// your code
		long index = 0;
		long sum = 0;
		while (true) {
			sum += index * index * index;
			if (sum == m) {
				return index;
			} else if (sum > m) {
				System.out.println(sum + ":::" + index);
				return -1;
			}
			index++;
		}
	}
}
