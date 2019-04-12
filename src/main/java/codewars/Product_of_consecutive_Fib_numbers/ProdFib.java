package codewars.Product_of_consecutive_Fib_numbers;

public class ProdFib {

	public static long[] productFib(long prod) {
		// your code
		// 피보나치 함수를 구하고, F(n) * F(n+1) 되는 숫자면 true를 반환
		// F(n) * F(n+1) < prod < F(n+1) * F(n+2) 라면 F(n+1), F(n+2), false 반환
		long[] array = new long[100];
		array[1] = 1;
		array[2] = 1;
		int index = 1;
		while (true) {
			fibo(array, ++index);
			long cal = array[index] * array[index - 1];
			if (cal < prod) {
				continue;
			} else if (cal == prod) {
				return new long[] { array[index - 1], array[index], 1 };
			} else {
				return new long[] { array[index - 1], array[index], 0 };
			}
		}
	}
	
	public static long[] productFib2(long prod) {
		// your code
		// 피보나치 함수를 구하고, F(n) * F(n+1) 되는 숫자면 true를 반환
		// F(n) * F(n+1) < prod < F(n+1) * F(n+2) 라면 F(n+1), F(n+2), false 반환
		long a = 0l;
		long b = 1l;
		while (a * b < prod) {
			long temp = a;
			a = b;
			b = temp + b; 
		}
		return new long[] {a, b, a * b == prod ? 1 : 0};
	}

	public static long fibo(long[] array, int index) {
		return array[index] = array[index - 1] + array[index - 2];
	}
}
