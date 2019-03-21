package bookAlgorithms.dynamicPrograming;

public class Fibonazzi {
	// 1, 1, 2, 3, 5, 8, 13
	static int[] cache;
	public static int fibonazzi(int[] cache, int number) {
		if (number == 1 || number == 2) {
			cache[number] = 1;
			return cache[number];
		} else if (cache[number] != 0) {
			return cache[number];
		}
		cache[number] = fibonazzi(cache, number - 1) + fibonazzi(cache, number - 2);
		return cache[number];
	}
	
	public static void main(String[] args) {
		int number = 1000;
		cache = new int[number+1];
		for (int i = 3; i < 1000; i++) {
			System.out.println("index : "+i+", result : "+fibonazzi(cache, i));
		}
	}
}
