package etc.joy;

public class Fibonazzi {
	
	static int fibo(int num) {
		// f(n) = f(n-1) + f(n-2)
		// 0, 1, 1, 2, 3, 5, 8, ....
		int sum = 1;
		int prev = 0;
		for (int i = 2; i <= num; i++) {
			int temp = sum;
			sum = sum + prev;
			prev = temp;
//			System.out.println(sum);
		}
		return sum;
	}
	
	static int fiboReC(int num) {
		// f(n) = f(n-1) + f(n-2)
		// f(n) = (f(n-2) + f(n-3)) + (f(n-3) + f(n-4))
		if (num == 0) {
			return 0;
		} else if (num == 1 || num == 2) {
			return 1;
		}
		
		return fiboReC(num-1) + fiboReC(num-2);
	}
	
	public static void main(String[] args) {
		int num = 7;
		System.out.println(fibo(num));
		System.out.println(fiboReC(num));
	}
}
