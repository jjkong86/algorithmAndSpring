package baekJoon;

import java.math.BigDecimal;
import java.util.Scanner;

public class Number11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCount = sc.nextInt();
		BigDecimal number = sc.nextBigDecimal();
		BigDecimal piece = new BigDecimal(0);
		BigDecimal ten = new BigDecimal(10);
		for (int i = 0; i < numCount; i++) {
			BigDecimal temp =number.remainder(ten);
			piece = piece.add(temp);
			number = number.divide(ten, BigDecimal.ROUND_DOWN);
		}
		System.out.println(piece);
		sc.close();
	}
}
