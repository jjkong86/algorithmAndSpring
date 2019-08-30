package etc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Test9 {
	
	public static class Number {
		double num;
		
		Number(double num) {
			this.num = num;
		}
	}
	
	public static void main(String[] args) {
		double balance = 0.04089218;
		double totalAmount = 0.00761700;
		double calFee = 0.00000082;
		
		BigDecimal convertBalance =  new BigDecimal(String.valueOf(balance));
		BigDecimal convertTotalAmount =  new BigDecimal(String.valueOf(totalAmount));
		BigDecimal totalSumAmount = new BigDecimal("0.007617");
		
		if (convertTotalAmount.equals(totalSumAmount) || 
				convertBalance.compareTo(totalSumAmount.add(new BigDecimal(String.valueOf(calFee)))) > -1) { // 수수료 + 보낼 금액은 잔액보다 작거나 같아야함
			System.out.println("들어옴?");
		}
		
		Number[] nums = new Number[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = new Number((double)i);
		}
		DecimalFormat fmt = new DecimalFormat("#.##########");
		BigDecimal sum = Arrays.stream(nums).map(Number -> new BigDecimal(fmt.format(Number.num))).reduce(BigDecimal::add).get();
		System.out.println(sum);
		
		StringBuilder sb = new StringBuilder("#.");
		IntStream.range(0, 8).forEach(i -> sb.append("#"));
		
		DecimalFormat fmt1 = new DecimalFormat(sb.toString());
		System.out.println(fmt1.format(calFee));
	}
}
