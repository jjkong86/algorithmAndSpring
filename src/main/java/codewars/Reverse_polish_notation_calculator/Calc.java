package codewars.Reverse_polish_notation_calculator;

import java.util.*;

public class Calc {

	public double evaluate(String expr) {
		// TODO: Your awesome code here
		// 5 1 2 + 4 * + 3 -
		// 5 1 2 + -> 5 (1+2) -> 5 (1+2) 4 * -> 5 (1+2)*4 -> 5 + (1+2)*4 3 - -> (5 +
		// (1+2)*4)-3
		if (expr.equals("")) {
			return 0;
		} else if (expr.length() == 1) {
			return Double.parseDouble(expr);
		}

		Stack<Double> stack = new Stack<>();
		String[] split = expr.split(" ");
		int len = split.length;
		for (int i = 0; i < len; i++) {
			String str = split[i];
			if (isNumberic(str)) {
				stack.push(Double.parseDouble(str));
			} else if (str.equals("+")) {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b + a);
			} else if (str.equals("-")) {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b - a);
			} else if (str.equals("*")) {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b * a);
			} else if (str.equals("/")) {
				double a = stack.pop();
				double b = stack.pop();
				stack.push(b / a);
			}
		}
		return stack.pop();
	}
	
	public static boolean isNumberic(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
