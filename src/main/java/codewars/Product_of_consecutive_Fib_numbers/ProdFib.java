package codewars.Product_of_consecutive_Fib_numbers;

import java.util.ArrayList;
import java.util.List;

public class ProdFib {

	public static long[] productFib(long prod) {
		// your code
		// 피보나치 함수를 구하고, F(n) * F(n+1) 되는 숫자면 true를 반환
		// F(n) * F(n+1) < prod < F(n+1) * F(n+2) 라면 F(n+1), F(n+2), false 반환
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		int index = 1;
		while (true) {
			fibo(list, ++index);
			long cal = list.get(index) * list.get(index-1);
			if (cal < prod) {
				continue;
			} else if (cal == prod){
				return new long[] { list.get(index-1), list.get(index), 1 };
			} else {
				return new long[] { list.get(index-1), list.get(index), 0 };
			}
		}
	}

	public static void fibo(List<Integer> list, int index) {
		list.add(list.get(index-1) + list.get(index-2));
	}
}
