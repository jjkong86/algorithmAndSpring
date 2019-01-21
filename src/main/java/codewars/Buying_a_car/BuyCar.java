package codewars.Buying_a_car;

public class BuyCar {

	public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
		// your code
		if (startPriceOld > startPriceNew) {
			return new int[] {0, startPriceOld - startPriceNew};
		}
		double oldP = startPriceOld;
		double newP = startPriceNew;
		double cash = 0;
		int flag = -1;
		int count = 0;
		double percent = (100 - (percentLossByMonth))/100;
		while (cash < newP) {
			percent = percent - (flag == -1 ? 0 : 0.005);
			oldP = oldP * percent;
			newP = newP * percent;
			cash = oldP + (savingperMonth * ++count);
			flag *= -1;
		}
		System.out.println((int) Math.round(cash - newP));
		return new int[] {count, (int) Math.round(cash - newP)};
	}
}